package com.abc.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangeNPwd extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String np = request.getParameter("np");
		Model model = new Model();
		model.setEmail(email);
		model.setNp(np);
		boolean status = model.forgotPassword();
		if(status==false)
		{
			response.sendRedirect("/BankApp/Fail.html");
		}
		else
		{
			response.sendRedirect("/BankApp/Success.html");
		}
	}
}
