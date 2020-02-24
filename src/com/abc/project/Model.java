package com.abc.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	String custid;
	String pwd;
	String name;
	int accno;
	int balance;
	String email;
	int raccno;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet res=null;
	private int qry1;
	private int qry2;
	private int qry3;
	private int amnt;
	public ArrayList al = new ArrayList();
	int amount;
	String np;
	
	public String getNp() {
		return np;
	}
	public void setNp(String np) {
		this.np = np;
	}
	public int getAmnt() {
		return amnt;
	}
	public void setAmnt(int amnt) {
		this.amnt = amnt;
	}
	public int getRaccno() {
		return raccno;
	}
	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	Model()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	boolean login()
	{
		con = getConnection();
		try 
		{
			pstmt = con.prepareStatement("SELECT * FROM SWISS_BANK WHERE CUSTID=? AND PWD=?");
			pstmt.setString(1,custid);
			pstmt.setString(2,pwd);
			res = pstmt.executeQuery();
			if (res.next()) {
				name = res.getString(1);
				accno = res.getInt(2);
				balance = res.getInt(3);
				custid = res.getString(4);
				pwd = res.getString(5);
				email = res.getString(6);
				return true;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				if (res!=null) {
					res.close();
				}
				if (pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}

			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return false;
	}
	boolean checkBalance()
	{
		con = getConnection();
		try {
			pstmt = con.prepareStatement("SELECT * FROM SWISS_BANK WHERE ACCNO=?");
			pstmt.setInt(1,accno);
			res = pstmt.executeQuery();
			if (res.next()) {
				name = res.getString("NAME");
				balance = res.getInt("BALANCE");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (res!=null) {
					res.close();
				}
				if (pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}

			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return false;
	}
	boolean changePwd()
	{
		con = getConnection();
		try {
			pstmt = con.prepareStatement("UPDATE SWISS_BANK SET PWD = ? WHERE ACCNO = ?");
			pstmt.setString(1, pwd);
			pstmt.setInt(2, accno);
			int result = pstmt.executeUpdate();
			if (result==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return false;
	}
	boolean transfer()
	{
		con = getConnection();
		try {
			pstmt = con.prepareStatement("SELECT * FROM SWISS_BANK WHERE ACCNO = ?");
			pstmt.setInt(1,accno);
			res = pstmt.executeQuery();
			if(res.next()==true)
			{
				pstmt = con.prepareStatement("UPDATE SWISS_BANK SET BALANCE = BALANCE-? WHERE ACCNO = ?");
				pstmt.setInt(1, balance);
				pstmt.setInt(2, accno);
				qry1 = pstmt.executeUpdate();
				if (qry1==1) 
				{
					pstmt = con.prepareStatement("UPDATE SWISS_BANK SET BALANCE = BALANCE+? WHERE ACCNO = ?");
					pstmt.setInt(1, balance);
					pstmt.setInt(2, raccno);
					qry2 = pstmt.executeUpdate();
					if (qry2==1) 
					{
						pstmt = con.prepareStatement("INSERT INTO BANK_STATEMENT VALUES(?,?,?)");
						pstmt.setInt(1, accno);
						pstmt.setInt(2, balance);
						pstmt.setInt(3, raccno);
						pstmt.executeUpdate();
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(res!=null) {
					res.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	ArrayList getStatement()
	{
		con = getConnection();
		try
		{
			pstmt = con.prepareStatement("SELECT * FROM BANK_STATEMENT WHERE ACCNO = ?");
			pstmt.setInt(1, accno);
			res = pstmt.executeQuery();
			while(res.next())
			{
				amount = res.getInt(2);
				al.add(amount);
			}
			return al;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if(res!=null) {
					res.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return al;
	}
	boolean forgotPassword()
	{
		con = getConnection();
		try
		{
			pstmt = con.prepareStatement("UPDATE SWISS_BANK SET PWD = ? WHERE EMAIL = ?");
			pstmt.setString(1, np);
			pstmt.setString(2, email);
			int qr = pstmt.executeUpdate();
			if(qr==1)
				return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}	
}