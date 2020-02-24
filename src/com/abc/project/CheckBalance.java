package com.abc.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int accno;
	int balance;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		Model model = new Model();
		model.setAccno(accno);
		boolean result = model.checkBalance();
		balance = model.getBalance();
		session.setAttribute("balance",balance);
		if (result ==true) {
			try {
				response.sendRedirect("/BankApp/checkBalance.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("/BankApp/errorCheckBalance.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
