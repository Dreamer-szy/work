package com.szy.util;

import java.sql.Connection;
import java.sql.DriverManager;

//数据库工具类
public class DBUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/data";//连接数据库
	private String dbUserName = "root";
	private String dbPassword = "123456";
	private String jdbcName = "com.mysql.jdbc.Driver"; //驱动程序
	
	//获取数据库连接
	public Connection getCon()throws Exception
	{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	//关闭数据库连接
	public void closeCon(Connection con)throws Exception
	{
		if(con!=null)
			con.close();
	}
	
	//测试连接
	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
