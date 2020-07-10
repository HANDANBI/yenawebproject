package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.*;
import com.vo.*;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({ "/blist", "/binsert", "/bfind", "/bdelete","/blike", "/bupdate" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getRequestURI(); 
		if(str.endsWith("blist")) {
			doBlist(request,response);
			
		}else if(str.endsWith("binsert")) {
			doBinsert(request,response);			
		}else if(str.endsWith("bfind")) {
			doBfind(request,response);
		}else if(str.endsWith("bdelete")) {
			doBdelete(request,response);
		}else if(str.endsWith("blike")) {
			doBlike(request,response);
		}else if(str.endsWith("bupdate")) {
			doBupdate(request,response);
		}else {
			//예외처리, 에러페이지, 입세션
			System.out.println(str + ":" + str.endsWith(str));
		}
	}
	
	private void doBupdate(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("budpate");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int ubid = Integer.parseInt(request.getParameter("ubid"));
		BoardVO myBoard = new BoardVO();
		myBoard.setBid(ubid);
		myBoard.setTitle(request.getParameter("title"));
		myBoard.setBooktitle(request.getParameter("booktitle"));
		myBoard.setGenre(request.getParameter("genre"));
		myBoard.setText(request.getParameter("text"));
		myBoard.setBwriter((String)request.getSession().getAttribute("MyID"));
		
		System.out.println(myBoard.getTitle());
		
		boolean fw = new BoardBIZ().updateBoard(myBoard);
		
		if(fw) {
			try {
				response.sendRedirect(request.getContextPath()+"/board/view_board.jsp?bid=" + myBoard.getBid());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//에러페이지 이동 혹은 재입력 페이지로 이동시킨다
		}
		
	}

	private void doBlike(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		new BoardBIZ().plusGrade(bid);
		
		try {
			response.sendRedirect(request.getContextPath()+"/board/view_board.jsp?bid=" + bid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void doBdelete(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		boolean fw = new BoardBIZ().deleteBoard(bid);
		
		if(fw) {
			try {
				response.sendRedirect(request.getContextPath()+"/blist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//에러페이지 이동 혹은 재입력 페이지로 이동시킨다
		}
		
	}

	private void doBlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("blist");
		List<BoardVO> all= new BoardBIZ().getBoardALL();
		int count = new BoardBIZ().getBoardCount();
		RequestDispatcher rd = req.getRequestDispatcher("/board/list_board.jsp");
		req.setAttribute("ball", all);//ball = all
		req.setAttribute("bcount", count);//bcount = count
		rd.forward(req, resp);//주소줄에 요청받은 제어권을 memberAll.jsp 넘긴다.
	}
	private void doBfind(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void doBinsert(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("binsert");
		request.setCharacterEncoding("UTF-8");
		BoardVO myBoard = new BoardVO();
		myBoard.setTitle(request.getParameter("title"));
		myBoard.setBooktitle(request.getParameter("booktitle"));
		myBoard.setGenre(request.getParameter("genre"));
		myBoard.setText(request.getParameter("text"));
		myBoard.setBwriter((String)request.getSession().getAttribute("MyID"));
		
		System.out.println(myBoard.getTitle());
		
		boolean fw = new BoardBIZ().insertBoard(myBoard);
		
		if(fw) {
			try {
				response.sendRedirect(request.getContextPath()+"/blist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//에러페이지 이동 혹은 재입력 페이지로 이동시킨다
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}