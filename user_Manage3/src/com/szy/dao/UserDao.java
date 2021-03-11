package com.szy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.szy.model.User;
import com.szy.util.DBUtil;

//用户Dao类

public class UserDao {
	//登录页面
	public User login(Connection con,User user)throws Exception
	{
		User resultUser=null;
		String sql = "select * from user where username=? and passwd=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPasswd());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			resultUser=new User();
			resultUser.setId(rs.getString("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setAge(rs.getInt("age"));
			resultUser.setProfile(rs.getString("profile"));
			resultUser.setSex(rs.getString("sex"));
			resultUser.setPasswd(rs.getString("passwd"));
		}
		return resultUser;
	}
	public static boolean updateUser(User u) {
		DBUtil dbUtil = new DBUtil();
		try {
			Connection con = dbUtil.getCon();
			String sql1 = "update user set username=?,age=?,sex=?,profile=? where id=?;";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(5, u.getId());
			ps.setString(1, u.getUsername());	
			ps.setInt(2, u.getAge());
			ps.setString(3, u.getSex());				
			ps.setString(4, u.getProfile());
//			ps.setString(6, u.getHeadImg());
			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		// id,name,psw,gender,age,about,headImg
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
