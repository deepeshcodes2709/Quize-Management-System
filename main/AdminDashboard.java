package quizmanagementsystem.main;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Image;

public class AdminDashboard extends JFrame {

    JButton btnCreateQuiz;
    JButton btnListQuiz;
    JButton btnViewResults;
    JButton btnDeleteQuiz;
    JButton btnLogout;

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        ImageIcon windowIcon = new ImageIcon("images/logo.png");

        setIconImage(windowIcon.getImage());
        setSize(650,650);
        setLayout(null);

        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245,247,250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon adminIcon = new ImageIcon("images/admin.png");

        Image img = adminIcon.getImage();

        Image resizeImg = img.getScaledInstance(
                80,
                80,
                Image.SCALE_SMOOTH);

        JLabel lblAdmin =
                new JLabel(new ImageIcon(resizeImg));

        lblAdmin.setBounds(285,10,80,80);

        add(lblAdmin);
        
        JLabel heading = new JLabel("ADMIN DASHBOARD");
//        heading.setBounds(0,40,650,40);
        heading.setBounds(0,95,650,40);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI",Font.BOLD,32));
        heading.setForeground(new Color(41,128,185));
        add(heading);

        btnCreateQuiz = new JButton("Create Quiz");
        btnCreateQuiz.setBounds(185,170,280,50);
        btnCreateQuiz.setBackground(new Color(46,204,113));
        btnCreateQuiz.setForeground(Color.WHITE);
        btnCreateQuiz.setFont(new Font("Segoe UI",Font.BOLD,18));
        btnCreateQuiz.setFocusPainted(false);
        btnCreateQuiz.setBorder(BorderFactory.createEmptyBorder());
        btnCreateQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCreateQuiz.addActionListener(e -> {

            new CreateQuiz();

            dispose();

        });

        btnListQuiz = new JButton("List Quizzes");
        btnListQuiz.setBounds(185,240,280,50);
        btnListQuiz.setBackground(new Color(52,152,219));
        btnListQuiz.setForeground(Color.WHITE);
        btnListQuiz.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnListQuiz.setFocusPainted(false);
        btnListQuiz.setBorder(new LineBorder(new Color(41,128,185),2,true));
        btnListQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnListQuiz.addActionListener(e -> {

            new ListQuizFram();

            dispose();

        });

        btnViewResults = new JButton("View Results");
        btnViewResults.setBounds(185,310,280,50);
        btnViewResults.setBackground(new Color(155,89,182));
        btnViewResults.setForeground(Color.WHITE);
        btnViewResults.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnViewResults.setFocusPainted(false);
        btnViewResults.setBorder(new LineBorder(new Color(142,68,173),2,true));
        btnViewResults.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnViewResults.addActionListener(e -> {
        	
        	new ViewResults();
        	
        	dispose();
        });

        btnDeleteQuiz = new JButton("Delete Quiz");
        btnDeleteQuiz.setBounds(185,380,280,50);
        btnDeleteQuiz.setBackground(new Color(231,76,60));
        btnDeleteQuiz.setForeground(Color.WHITE);
        btnDeleteQuiz.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnDeleteQuiz.setFocusPainted(false);
        btnDeleteQuiz.setBorder(new LineBorder(new Color(192,57,43),2,true));
        btnDeleteQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDeleteQuiz.addActionListener(e -> {

            new DeleteQuiz();

            dispose();

        });

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(185,460,280,50);
        btnLogout.setBackground(new Color(52,73,94));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnLogout.setFocusPainted(false);
        btnLogout.setBorder(new LineBorder(new Color(44,62,80),2,true));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(btnCreateQuiz);
        add(btnListQuiz);
        add(btnViewResults);
        add(btnDeleteQuiz);
        add(btnLogout);

        btnLogout.addActionListener(e -> {

            new HomeFrame();

            dispose();

        });

        setVisible(true);
    }
}