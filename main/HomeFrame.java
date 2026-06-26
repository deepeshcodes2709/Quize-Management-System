package quizmanagementsystem.main;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Image;
import java.awt.Cursor;

public class HomeFrame extends JFrame {

    JButton btnAdminLogin, btnStudentRegister, btnStudentLogin, btnExit;
    JLabel lblTitle;

    public HomeFrame() {

        setTitle("Quiz Management System");
        ImageIcon logo = new ImageIcon("images/logo.png");
        setIconImage(logo.getImage()); 
        setSize(700,720);
        getContentPane().setBackground(new Color(248,250,252));
        
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon student = new ImageIcon("images/student.png");

        Image img = student.getImage();

        Image resize = img.getScaledInstance(
        100,
        100,
        Image.SCALE_SMOOTH);

        JLabel lblImage = new JLabel(new ImageIcon(resize));

        lblImage.setBounds(300,20,100,100);

        add(lblImage);
        getContentPane().setBackground(new Color(248,250,252));

        lblTitle = new JLabel("QUIZ MANAGEMENT SYSTEM");
        lblTitle.setBounds(0,140,700,40);

        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 34));

        lblTitle.setForeground( new Color(41,128,185));
    
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 34));
        lblTitle.setForeground(new Color(41,128,185));
        

        btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.setBounds(180,260,340,55);

        btnStudentRegister = new JButton("Student Register");
        btnStudentRegister.setBounds(180,335,340,55);

        btnStudentLogin = new JButton("Student Login");
        btnStudentLogin.setBounds(180,410,340,55);

        btnExit = new JButton("Exit");
        btnExit.setBounds(180,485,340,55);

        add(lblTitle);
        add(btnAdminLogin);
        add(btnStudentRegister);
        add(btnStudentLogin);
        add(btnExit);

        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new AdminLoginFrame();

                dispose();
            }
        });

        
        btnStudentRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new StudentRegisterFrame();

                dispose();
            }
        });

        btnStudentLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminLoginFrame();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        getContentPane().setBackground(new Color(240, 248, 255)); // Light Blue

        setVisible(true);
    }
}