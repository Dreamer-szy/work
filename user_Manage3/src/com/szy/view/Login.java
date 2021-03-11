package com.szy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.szy.dao.UserDao;
import com.szy.model.Info;
import com.szy.model.User;
import com.szy.util.DBUtil;
import com.szy.util.StringUtil;
import com.mysql.jdbc.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwdTxt;
	private JTextField usernameTxt;
	
	private DBUtil dbutil = new DBUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(247, 64, 192, 40);
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/\u7528\u62371.png")));
		lblNewLabel_1.setBounds(74, 136, 134, 74);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 27));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/image/\u5BC6\u78011.png")));
		lblNewLabel_2.setBounds(84, 234, 150, 56);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 27));
		
		passwdTxt = new JPasswordField();
		passwdTxt.setBounds(223, 240, 246, 48);
		passwdTxt.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setBounds(164, 327, 79, 35);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(534, 375, 79, 35);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(223, 153, 246, 44);
		usernameTxt.setFont(new Font("宋体", Font.PLAIN, 23));
		usernameTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u6CE8\u518C");
		btnNewButton_2.setBounds(360, 328, 79, 35);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//注册
				user_add infoadd = new user_add();
				infoadd.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 22));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(usernameTxt);
		contentPane.add(passwdTxt);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
		//居中设置
		this.setLocationRelativeTo(null);
	}
	
	//登录
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String username = this.usernameTxt.getText();
		String passwd = new String(this.passwdTxt.getPassword());
		if(StringUtil.isEmpty(username))
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(passwd))
		{
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user = new User(username,passwd);
		Connection con = null;
		try {
			con=(Connection) dbutil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser!=null)
			{
				new userFram2(currentUser).setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名密码错误！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	//重置事件处理
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.usernameTxt.setText("");
		this.passwdTxt.setText("");
	}
}
