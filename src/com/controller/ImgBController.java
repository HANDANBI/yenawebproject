package com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.MyUtil;
import com.vo.*;
/**
 * Servlet implementation class ImgBController
 */
@WebServlet({ "/imlist", "/iminsert", "/imdelete", "/iminsert_ok" })
public class ImgBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgBController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtil myUtil = new MyUtil();
		String cp = request.getContextPath();
		String url;
		
		String root = getServletContext().getRealPath("/");
		String path = root + File.separator+"pds" +File.separator+"imageFile";
		File f =new File(path);
		
		String uri = request.getRequestURI(); 
		
		if(uri.endsWith("imlist")) {
			doImlist(request,response);	
		}else if(uri.endsWith("iminsert")) {
			doIminsert(request,response);			
		}else if(uri.endsWith("imdelete")) {
			doImdelete(request,response);
		}else if(uri.endsWith("iminsert_ok")) {
			doIminsert_ok(request,response);
		}else {
			//예외처리, 에러페이지, 입세션
			System.out.println(uri + ":" + uri.endsWith(uri));
		}
	}
	
	private void doImlist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int dataCount = new ImageBIZ().getDataCount();
		int numPerPage = 9;
		int totalPage = new MyUtil().getPageCount(numPerPage, dataCount);
		if(currentPage > totalPage)
			currentPage = totalPage;
		int end = dataCount - (numPerPage * (currentPage - 1));
		int start = end - numPerPage + 1 < 1 ? 1 : end - numPerPage + 1;
		
		String listUrl = request.getContextPath() +"/imlist";
		List<ImageVO> lists=new ImageBIZ().getList(start, end);
		String pageIndexList = new MyUtil().pageIndexList(currentPage, totalPage, listUrl);
		
		String deletePath = request.getContextPath() +"/imdelete";
		
		String imagePath = request.getContextPath() +"/pds/imageFile";
		request.setAttribute("imagePath", imagePath);
		
		request.setAttribute("dataCount", dataCount);
		request.setAttribute("lists", lists);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("deletePath", deletePath);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("totalArticle", dataCount);
		request.setAttribute("totalPage", totalPage);
		
		String url="/board/list_image.jsp";
		
		try {
			forward(request,response,url);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doIminsert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String url = "/board/input_image.jsp";
		
		forward(request,response,url);
		
		
	}

	private void doIminsert_ok(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String encType="UTF-8";
		
		int maxSize =10*1024*1024;
		
		MultipartRequest mr = new MultipartRequest(request 
					,getServletContext().getRealPath("/") + File.separator+"pds" +File.separator+"imageFile"
					,maxSize,encType, new DefaultFileRenamePolicy());
		
		
		if(mr.getFile("uploadFile") !=null) {
			ImageVO vo = new ImageVO();
			int maxNum = new ImageBIZ().getMaxNum();
			
			
			
			vo.setBid(maxNum+1);
			System.out.println(maxNum);
			vo.setItitle(mr.getParameter("ititle"));
			vo.setSavefilename(mr.getFilesystemName("uploadFile"));
			new ImageBIZ().insertData(vo);
		}
		
		String url = request.getContextPath() + "/imlist";
		
			response.sendRedirect(url);
	
		
	}
	
	private void doImdelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num = Integer.parseInt(request.getParameter("bid"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		ImageVO vo = new ImageBIZ().getReadData(num);
		doFileDelete(vo.getSavefilename(), 
				getServletContext().getRealPath("/") + File.separator+"pds" +File.separator+"imageFile");
		
		new ImageBIZ().deleteData(num);
		
		String url = request.getContextPath() +"/imlist?currentPage="+currentPage;
		response.sendRedirect(url);
		
	}
	protected void forward(HttpServletRequest req, HttpServletResponse resp,String url) throws ServletException,IOException{
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public static boolean doFileDownload(HttpServletResponse resp,String savefilename , String originalfilename,String path) {
		try {
			String filePath = path+ File.separator+savefilename;
			
			if(originalfilename == null || originalfilename.equals("") ) {
				originalfilename = savefilename;
			}
			
			originalfilename = new String(originalfilename.getBytes("euc-kr"),"ISO-8859-1");
			
			File f = new File(filePath);
			
			if(!f.exists()) {
				return false;
			}
			
			resp.setContentType("application/octet-stream");
			
			resp.setHeader("Content-disposition", "attachment;filename="+originalfilename);
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			
			OutputStream out = resp.getOutputStream();
			
			int data;
			
			byte bytes[] = new byte[4096];
			
			while((data=bis.read(bytes,0,4096)) !=-1) {
				out.write(bytes,0,data);
			}
			
			out.flush();
			out.close();
			bis.close();
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	//파일 삭제
	public static void doFileDelete(String filename,String path) {
		try {
			String filePath = path+File.separator+filename;
			File f = new File(filePath);
			
			if(f.exists()) {
				f.delete();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
