package com.szy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.szy.dao.UserDao;
import com.szy.model.Info;
import com.szy.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class userFram2 extends JFrame {

	private JPanel contentPane;
	private JTextField s_id;
	private JTextField s_name;
	private JTextField s_age;
	private JTextField s_profile;
	private JRadioButton s_man;
	private JRadioButton s_woman ;
	private User u = new User();
	private Login login = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userFram2 frame = new userFram2(new User());
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
	public userFram2(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel.setBounds(40, 51, 93, 27);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(40, 106, 93, 27);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_2.setBounds(40, 168, 93, 27);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_3.setBounds(40, 226, 93, 27);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabel_3_1 = new JLabel("\u7B80\u4ECB\uFF1A");
		lblNewLabel_3_1.setBounds(44, 297, 93, 27);
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 23));
		
		s_id = new JTextField();
		s_id.setBounds(138, 50, 116, 32);
		s_id.setEditable(false);
		s_id.setFont(new Font("宋体", Font.PLAIN, 22));
		s_id.setColumns(10);
		
		s_name = new JTextField();
		s_name.setBounds(138, 107, 116, 32);
		s_name.setFont(new Font("宋体", Font.PLAIN, 22));
		s_name.setColumns(10);
		
		s_age = new JTextField();
		s_age.setBounds(137, 170, 116, 32);
		s_age.setFont(new Font("宋体", Font.PLAIN, 22));
		s_age.setColumns(10);
		
		JRadioButton s_man = new JRadioButton("\u7537");
		s_man.setBounds(135, 226, 55, 35);
		s_man.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JRadioButton s_woman = new JRadioButton("\u5973");
		s_woman.setBounds(214, 225, 55, 35);
		s_woman.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JButton s_save = new JButton("\u4FDD\u5B58");
		s_save.setBounds(253, 513, 134, 35);
		s_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ms =checkUserInfo();
				if(!"ok".equals(ms))
				{   
					JOptionPane.showMessageDialog(null,ms, "信息提示",JOptionPane.WARNING_MESSAGE);
				}else{					
					 u.setId(s_id.getText().trim());
					 u.setUsername(s_name.getText());						
					 u.setProfile(s_profile.getText());					 
					 if(UserDao.updateUser(u)) {  
				    	JOptionPane.showMessageDialog(null, "更新成功，请重新登录");
					    login.setVisible(true);
					    dispose();
					 }else {
						 JOptionPane.showMessageDialog(null, "更新失败，请检查数据库是否正常启动"); 
					 }
				}
			}
		});
		s_save.setFont(new Font("宋体", Font.PLAIN, 22));
		
		s_profile = new JTextField();
		s_profile.setBounds(143, 297, 412, 198);
		s_profile.setFont(new Font("宋体", Font.PLAIN, 23));
		s_profile.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(561, 60, 18, 173);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(userFram2.class.getResource("/image/cat.png")));
		lblNewLabel_5.setBounds(367, 50, 173, 211);
		//居中设置
		this.setLocationRelativeTo(null);
		s_id.setText(u.getId());
		s_name.setText(u.getUsername());
		s_age.setText(""+u.getAge());
		s_profile.setText(u.getProfile());
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_3_1);
		contentPane.add(s_profile);
		contentPane.add(lblNewLabel_3);
		contentPane.add(s_man);
		contentPane.add(s_woman);
		contentPane.add(lblNewLabel_2);
		contentPane.add(s_age);
		contentPane.add(lblNewLabel_1);
		contentPane.add(s_name);
		contentPane.add(lblNewLabel);
		contentPane.add(s_id);
		contentPane.add(lblNewLabel_4);
		contentPane.add(s_save);
		
		if(u.getSex().equals("男")) {
			s_man.setSelected(true);  
		}else {
			s_woman.setSelected(true);
		}
	}
	
	private String checkUserInfo() {
		if("".equals(s_name.getText())) return "用户名不能为空！";
		if("".equals(s_id.getText())) return "用户id不能为空！";   //双保险
		int age_1 = checkAge();
		if(age_1==-1) return "年龄输入错误！";
		else {u.setAge(age_1);}
//		if(s_man.isSelected()) 	u.setSex("男");   
//		if(s_woman.isSelected())   u.setSex("女");		
		return "ok";
	}
	
	//检查年龄	
	private int checkAge() {
		String num = s_age.getText().trim();
		if(num.matches("\\d+")) {
			int n =Integer.parseInt(num);
			if(n>0 && n<100) {
				return n;
			}else {
				return -1;
			}
		}
		return -1;
	}
}
