package com.insurance.Insurance_spring.domain.dao;


import java.sql.*;

public class Dao {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void connect() throws Exception {
		//connect
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?serverTimezone=UTC&useSSL=false", "root", "339675"); //ä��
//			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?serverTimezone=UTC&useSSL=false", "root", "1234qwer"); //�Ը�
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//create
	public void execute(String query) throws Exception {
		try {
			statement = connect.createStatement();
			statement.execute(query);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ResultSet retrieve(String query) throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			return resultSet;
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
