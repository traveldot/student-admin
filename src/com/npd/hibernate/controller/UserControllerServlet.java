package com.npd.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.npd.hibernate.bean.User;
import com.npd.hibernate.dao.UserDAO;

public class UserControllerServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword1(request.getParameter("password1"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setCity(request.getParameter("city"));
		
		HttpSession session = request.getSession(true);
		
		try{
			UserDAO userdao = new UserDAO();
			userdao.addUserDetails(user);
			response.sendRedirect("SUCCESS");			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
