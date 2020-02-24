package com.abc.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	String custid;
	String pwd;
	private int accno;
	String name;
	private int balance;
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		custid = request.getParameter("custid");
		pwd = request.getParameter("pwd");
		Model model = new Model();
		model.setCustid(custid);
		model.setPwd(pwd);
		HttpSession session = request.getSession(true);
		boolean result = model.login();
		accno = model.getAccno();
		name=model.getName();
		balance = model.getBalance();
		session.setAttribute("accno",accno);
		session.setAttribute("name", name);
		session.setAttribute("balance", balance);
		if (result == true) {
			try {
				response.sendRedirect("/BankApp/home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			try {
				response.sendRedirect("/BankApp/errorLogin.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}