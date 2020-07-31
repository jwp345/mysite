package com.bit2020.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bit2020.mvc.util.MVCUtil;
import com.bit2020.mysite.repository.GuestbookRepository;
import com.bit2020.mysite.vo.GuestbookVo;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("a");
		
		if("insert".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestbookRepository().insert(vo);
			response.sendRedirect(request.getContextPath() + "/gb");
		} else if("deleteform".equals(action)){
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
//			rd.forward(request, response);
			MVCUtil.forward("/guestbook/deleteform", request, response);
		} else if("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
		
			new GuestbookRepository().delete(Long.parseLong(no), password);
//			response.sendRedirect(request.getContextPath()+"/gb");
			MVCUtil.redirect(request.getContextPath()+"/gb", request, response);
		}
		else {
			/* list */
			List<GuestbookVo> list = new GuestbookRepository().findAll();
			
			request.setAttribute("list", list);
			MVCUtil.forward("guestbook/list", request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
