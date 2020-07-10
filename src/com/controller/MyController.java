package com.controller;

import java.io.IOException;
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
 * Servlet implementation class MyController
 */
@WebServlet({ "/minsert", "/mdelete", "/mupdate", "/mlist", "/mfind", "/mlogin"})
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getRequestURI(); 
		if(str.endsWith("minsert")) {
			doMinsert(request,response);
			
		}else if(str.endsWith("mdelete")) {
			doMdelete(request,response);
			
		}else if(str.endsWith("mupdate")) {
			doMupdate(request,response);

		}else if(str.endsWith("mlist")) {
			doMlist(request,response);
		}else if(str.endsWith("mfind")) {
			doMfind(request,response);
		}else if(str.endsWith("mlogin")) {
			doMlogin(request,response);
		}else {
			//����ó��, ����������, �Լ���
			System.out.println(str + ":" + str.endsWith(str));
		}
	}

	private void doMlogin(HttpServletRequest request, HttpServletResponse response) {
	
		String myID = request.getParameter("id");
		String myPW = request.getParameter("pw");
	
		System.out.println(myID + " / " + myPW);
		boolean fw = new LoginBIZ().tryLogin(myID, myPW);
		try {
			if(fw) {
				System.out.println("����");
				response.sendRedirect(request.getContextPath()+"/member/loginOk.jsp?id=" + myID);
			}else {
				System.out.println("����");
				response.sendRedirect(request.getContextPath()+"/login/fail.html");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doMlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("list");
		List<LoginVO> all= new LoginBIZ().getMyLoginAll();
		RequestDispatcher
		rd= req.getRequestDispatcher("/member/memberAll.jsp");
		req.setAttribute("mall", all);//mall = all
		rd.forward(req, resp);//�ּ��ٿ� ��û���� ������� memberAll.jsp �ѱ��.
	}

	private void doMinsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		// ȸ������ �Է����������� ���� �����͸� biz�� �Ѱ� db�� �����Ѵ�.
		LoginVO mylogin = new LoginVO();
		mylogin.setId(req.getParameter("id"));
		mylogin.setPw(req.getParameter("pw"));
		mylogin.setName(req.getParameter("name"));
		mylogin.setEmail(req.getParameter("email"));
		boolean fw = new LoginBIZ().getMyLoginInsert(mylogin);
		
		if(fw) {
			resp.sendRedirect(req.getContextPath()+"/member/joinOk.jsp?id=" + mylogin.getId());
		}else {
			//���������� �̵� Ȥ�� ���Է� �������� �̵���Ų��
		}
		
		System.out.println("insert ");
	}
	private void doMdelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String id = req.getParameter("no");
		LoginVO mylogin = new LoginVO();
		mylogin.setId(id);
		boolean fw = new LoginBIZ().getMyLoginDelete(mylogin);
		if(fw) {
			resp.sendRedirect("/Day50/mlist");
		}
	}
	private void doMfind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String id = req.getParameter("no");
		LoginVO login = new LoginVO();
		login.setId(id);
		
		LoginVO res = new LoginBIZ().getMyLoginFind(login);
		
		RequestDispatcher
		rd= req.getRequestDispatcher("/member/memberfind.jsp");
		req.setAttribute("mylogin", res);//mylogin = res
		rd.forward(req, resp);//�ּ��ٿ� ��û���� ������� memberfind.jsp�� �ѱ��
		
	}
	private void doMupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		//post��û�� �ѱ� ���� ������ �ݵ�� �޼ҵ�� ������ش�
		req.setCharacterEncoding("euc-kr");
		LoginVO mylogin = new LoginVO();
		mylogin.setId(req.getParameter("id"));
		mylogin.setName(req.getParameter("name"));
		mylogin.setEmail(req.getParameter("email"));
		boolean fw = new LoginBIZ().getMyLoginUpdate(mylogin);
		
		if(fw) {
			resp.sendRedirect(req.getContextPath()+"/mlist");
		}else {
			//���������� �̵� Ȥ�� ���Է� �������� �̵���Ų��
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
