package quizmanagementsystem.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import quizmanagementsystem.daoimpl.userDaoimpl;
import quizmanagementsystem.model.Role;
import quizmanagementsystem.model.User;

public class AdminLoginFrame extends JFrame {

	JLabel lblTitle, lblEmail, lblPassword;
	JTextField txtEmail;
	JPasswordField txtPassword;
	JButton btnLogin, btnBack;

	public AdminLoginFrame() {

		setTitle("Login");
		setSize(500, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		lblTitle = new JLabel("LOGIN");
		lblTitle.setBounds(0, 40, 500, 40);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblTitle.setForeground(new Color(25, 118, 210));

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(80, 100, 100, 30);

		txtEmail = new JTextField();
		txtEmail.setBounds(180, 100, 200, 30);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(80, 150, 100, 30);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(180, 150, 200, 30);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(120, 250, 100, 35);
		btnLogin.setBackground(new Color(76, 175, 80));


		btnBack = new JButton("Back");
		btnBack.setBounds(260, 250, 100, 35);
		btnBack.setBackground(new Color(244, 67, 54));

		add(lblTitle);
		add(lblEmail);
		add(txtEmail);
		add(lblPassword);
		add(txtPassword);
		add(btnLogin);
		add(btnBack);

		btnLogin.addActionListener(e -> {

			try {

				String email = txtEmail.getText();
				String password = String.valueOf(txtPassword.getPassword());

				userDaoimpl udao = new userDaoimpl();

				User user = udao.login(email, password);

				if(user.getRole() == Role.ADMIN) {

				    JOptionPane.showMessageDialog(
				            null,
				            "Admin Login Successful");

				    new AdminDashboard();

				    dispose();

				} else if ((user.getRole() == Role.STUDENT)) {
					
					JOptionPane.showMessageDialog(null, "Student Login Successful");				
					
					new StudentDashboard(user.getId());
					
					dispose();

				} else {

					JOptionPane.showMessageDialog(null, "Invalid login details");

				}

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, ex.getMessage());

			}

		});

		btnBack.addActionListener(e -> {

			new HomeFrame();
			dispose();

		});

		getContentPane().setBackground(new Color(240, 248, 255));
		
		setVisible(true);
	}
	
	
}