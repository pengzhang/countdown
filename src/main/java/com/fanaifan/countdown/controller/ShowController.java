package com.fanaifan.countdown.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanaifan.countdown.model.Email;
import com.fanaifan.countdown.service.EmailService;

public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("show");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username") == null || session.getAttribute("username").equals(""))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	        dispatcher.forward(request, response);
		}
//		int page = Integer.parseInt(request.getParameter("page"));
//		int size = Integer.parseInt(request.getParameter("size"));
//		List<Email> emails = EmailService.getEmai(page, size);
		List<Email> emails = EmailService.getEmaiAll();
		request.setAttribute("emails", emails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/show.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
