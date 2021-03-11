
package com.szy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.szy.dao.InfoDao;
import com.szy.model.Info;
import com.szy.util.DBUtil;
import com.szy.util.StringUtil;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user_add extends JFrame {

	private JPanel contentPane;
	private JTextField c_nameTxt;
	private JTextField c_passwdTxt;
	private JTextField c_sexTxt;
	private JTextField c_ageTxt;
	private JTextField c_profile;
	
	private DBUtil dbutil = new DBUtil();
	private InfoDao infodao = new InfoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_add frame = new user_add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user_add() {
		setTitle("\u6CE8\u518C\u65B0\u7528\u6237");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setBounds(43, 29, 100, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(43, 79, 100, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(43, 132, 100, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74  \u9F84\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(43, 186, 100, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u81EA\u6211\u4ECB\u7ECD\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(40, 244, 115, 50);
		contentPane.add(lblNewLabel_4);
		
		c_nameTxt = new JTextField();
		c_nameTxt.setBounds(158, 43, 170, 27);
		contentPane.add(c_nameTxt);
		c_nameTxt.setColumns(10);
		
		c_passwdTxt = new JTextField();
		c_passwdTxt.setBounds(158, 93, 170, 27);
		contentPane.add(c_passwdTxt);
		c_passwdTxt.setColumns(10);
		
		c_sexTxt = new JTextField();
		c_sexTxt.setBounds(158, 146, 170, 27);
		contentPane.add(c_sexTxt);
		c_sexTxt.setColumns(10);
		
		c_ageTxt = new JTextField();
		c_ageTxt.setBounds(158, 200, 170, 27);
		contentPane.add(c_ageTxt);
		c_ageTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddActionPerformed(e);
			}
		});
		btnNewButton.setBounds(534, 389, 69, 29);
		contentPane.add(btnNewButton);
		
		c_profile = new JTextField();
		c_profile.setBounds(158, 258, 276, 149);
		contentPane.add(c_profile);
		c_profile.setColumns(10);
		
		this.setLocationRelativeTo(null);
	}

	//保存注册信息
	private void UserAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String addName = this.c_nameTxt.getText();
		String addPasswd = this.c_passwdTxt.getText();
		String addSex = this.c_sexTxt.getText();
		String addAge = this.c_ageTxt.getText();
		String addProfile = this.c_profile.getText();
		
		if(StringUtil.isEmpty(addName))
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(addPasswd))
		{
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		//插入数据
//		int n = st.executeUpdate("insert into user(id,username,passwd,sex,age,profile)"+"value(04,'赵六','efg','女','9','老板')");
		Info addinfo = new Info(addName,addPasswd,addSex,addAge,addProfile);
		Connection con = null;
		try {
				con=dbutil.getCon();
				int n = infodao.add(con, addinfo);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "注册成功！");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "注册失败");
				}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败");
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
