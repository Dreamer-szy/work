package com.szy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.standard.PresentationDirection;

import com.szy.model.Info;
import com.szy.util.StringUtil;

import java.sql.Connection;;

public class InfoDao {

	//����û�
	public int add(Connection con, Info info)throws Exception
	{
		String sql = "insert into user value(0,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, info.getC_name());
		pstmt.setString(2, info.getC_passwd());
		pstmt.setString(3, info.getC_sex());
		pstmt.setString(4, info.getC_age());
		pstmt.setString(5, info.getC_profile());
		return pstmt.executeUpdate();
	}
	
	//��ѯ����
	public ResultSet list(Connection con,Info info)throws Exception
	{
		String str = "select * from user";
		if(StringUtil.isNotEmpty(info.getC_name()))
		{
			str = "select * from user where username ='"+ info.getC_name()+"'";
//			System.out.println("ִ��������");
			if(StringUtil.isNotEmpty(info.getC_sex()))
			{
				str += " and sex='"+ info.getC_sex()+"'";
				//System.out.println("ִ�����棡");
			}
		}
		if(StringUtil.isNotEmpty(info.getC_sex()))
		{
			str = "select * from user where sex='"+ info.getC_sex()+"'";
			//System.out.println("ִ���Ա�");
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		return rs;
	}
}
