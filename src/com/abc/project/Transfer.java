package com.abc.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {

	private int accno;
	private String raccno;
	private String amnt;
	private int theRaccno;
	private int theAmnt;

	protected void service(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		amnt = request.getParameter("amnt");
		raccno = request.getParameter("raccno");
		theRaccno = Integer.parseInt(raccno);
		theAmnt = Integer.parseInt(amnt);
		Model model = new Model();
		model.setAccno(accno);
		model.setBalance(theAmnt);
		model.setRaccno(theRaccno);
		if (((int)session.getAttribute("balance"))>=theAmnt) {
			boolean result = model.transfer();
			if (result ==true) {
				try {
					if(model.checkBalance())
						session.setAttribute("balance", model.getBalance());
					response.sendRedirect("/BankApp/transferSuccess.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					response.sendRedirect("/BankApp/transferFail.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			else {
				try {
					response.sendRedirect("/BankApp/insBalance.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}
