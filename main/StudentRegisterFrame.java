package quizmanagementsystem.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.LineBorder;

import quizmanagementsystem.daoimpl.userDaoimpl;

public class StudentRegisterFrame extends JFrame {

    JLabel lblTitle, lblSubTitle;
    JLabel lblName, lblEmail, lblPassword;
    JLabel lblStudent;

    JTextField txtName;
    JTextField txtEmail;
    JPasswordField txtPassword;

    JButton btnRegister;
    JButton btnBack;

    public StudentRegisterFrame() {

        setTitle("Student Registration");

        ImageIcon logo = new ImageIcon("images/logo.png");
        setIconImage(logo.getImage());

        setSize(600,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(245,247,250));

        //================ STUDENT IMAGE ==================

        ImageIcon studentIcon = new ImageIcon("images/student.png");

        Image img = studentIcon.getImage();

        Image resize = img.getScaledInstance(100,100, Image.SCALE_SMOOTH);

        lblStudent = new JLabel(new ImageIcon(resize));

        lblStudent.setBounds(250,20,100,100);

        add(lblStudent);

        //================ HEADING ==================

        lblTitle =  new JLabel("STUDENT REGISTRATION");

        lblTitle.setBounds(0,130,600,40);

        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitle.setFont(new Font("Segoe UI",Font.BOLD,28));

        lblTitle.setForeground(new Color(41,128,185));

        add(lblTitle);

        //================ SUBTITLE ==================

        lblSubTitle = new JLabel("Create your account to start quizzes");

        lblSubTitle.setBounds(0,170,600,25);

        lblSubTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblSubTitle.setFont(new Font("Segoe UI",Font.PLAIN,15));

        lblSubTitle.setForeground(Color.GRAY);

        add(lblSubTitle);

        //================ LABELS ==================

        lblName = new JLabel("Name");
        lblName.setBounds(90,250,100,30);
        lblName.setFont(new Font("Segoe UI",Font.BOLD,16));

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(90,320,100,30);
        lblEmail.setFont(new Font("Segoe UI",Font.BOLD,16));

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(90,390,100,30);
        lblPassword.setFont(new Font("Segoe UI",Font.BOLD,16));

        //================ TEXTFIELDS ==================

        txtName = new JTextField();
        txtName.setBounds(210,245,280,40);
        txtName.setFont(new Font("Segoe UI",Font.PLAIN,15));
        txtName.setBorder(new LineBorder(new Color(52,152,219), 2,true));

        txtEmail = new JTextField();
        txtEmail.setBounds(210,315,280,40);
        txtEmail.setFont(new Font("Segoe UI",Font.PLAIN,15));
        txtEmail.setBorder(new LineBorder(new Color(52,152,219),2,true));

        txtPassword = new JPasswordField();
        txtPassword.setBounds(210,385,280,40);
        txtPassword.setFont(new Font("Segoe UI",Font.PLAIN,15));
        txtPassword.setBorder(new LineBorder(new Color(52,152,219),2, true));

        //================ REGISTER BUTTON ==================

        btnRegister = new JButton("Register");
        btnRegister.setBounds(120,500,160,45);

        btnRegister.setBackground(new Color(46,204,113));
        btnRegister.setForeground(Color.WHITE);

        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 16));

        btnRegister.setFocusPainted(false);

        btnRegister.setBorder( new LineBorder(new Color(39,174,96), 2,true));

        // Register Icon

        ImageIcon registerIcon = new ImageIcon("images/register.png");

        Image regImg = registerIcon.getImage().getScaledInstance(22, 22,  Image.SCALE_SMOOTH);

        btnRegister.setIcon(new ImageIcon(regImg));

        btnRegister.setHorizontalAlignment(SwingConstants.LEFT);

        btnRegister.setIconTextGap(15);

        //================ BACK BUTTON ==================

        btnBack = new JButton("Back");
        btnBack.setBounds(320,500,160,45);

        btnBack.setBackground(new Color(231,76,60));
        btnBack.setForeground(Color.WHITE);

        btnBack.setFont( new Font("Segoe UI", Font.BOLD,16));

        btnBack.setFocusPainted(false);

        btnBack.setBorder( new LineBorder( new Color(192,57,43), 2, true));

        // Back Icon

        ImageIcon backIcon =
                new ImageIcon("images/back.png");

        Image backImg = backIcon.getImage().getScaledInstance( 22, 22, Image.SCALE_SMOOTH);

        btnBack.setIcon(new ImageIcon(backImg));

        btnBack.setHorizontalAlignment( SwingConstants.LEFT);

        btnBack.setIconTextGap(15);

        //================ FOOTER ==================

        JLabel footer = new JLabel("© 2026 Quiz Management System");

        footer.setBounds(0,640,600,20);

        footer.setHorizontalAlignment( SwingConstants.CENTER);

        footer.setForeground(Color.GRAY);

        add(footer);

        //================ ADD COMPONENTS ==================

        add(lblName);
        add(lblEmail);
        add(lblPassword);

        add(txtName);
        add(txtEmail);
        add(txtPassword);

        add(btnRegister);
        add(btnBack);

        //================ REGISTER ACTION ==================

        btnRegister.addActionListener(e -> {

            try {

                String name = txtName.getText();
                String email = txtEmail.getText();
                String password =
                        String.valueOf(txtPassword.getPassword());

                userDaoimpl udao = new userDaoimpl();

                udao.Registration(name,email,password);

                JOptionPane.showMessageDialog(
                        null,
                        "Registration Successful");

                new HomeFrame();

                dispose();

            }

            catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());

            }

        });

        //================ BACK ACTION ==================

        btnBack.addActionListener(e -> {

            new HomeFrame();

            dispose();

        });

        setVisible(true);
    }
}