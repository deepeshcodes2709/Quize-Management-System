package quizmanagementsystem.main;

import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.LineBorder;

public class StudentDashboard extends JFrame {
	
	private int studentId;

    JButton btnViewQuiz;
    JButton btnTakeQuiz;
    JButton btnViewScore;
    JButton btnLogout;

    JLabel lblTitle;

    public StudentDashboard(int studentId) {
    	
    	 this.studentId = studentId;

        setTitle("Student Dashboard");
        setSize(650,700);
        getContentPane().setBackground(new Color(248,250,252));
        ImageIcon logo = new ImageIcon("images/logo.png");
        setIconImage(logo.getImage());
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon student = new ImageIcon("images/student.png");
        Image img = student.getImage();
        Image resize = img.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        JLabel lblStudent = new JLabel(new ImageIcon(resize));
        lblStudent.setBounds(275,20,100,100);
        add(lblStudent);
        

        lblTitle = new JLabel("STUDENT DASHBOARD");
        lblTitle.setBounds(0,130,650,40);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI",Font.BOLD,32));
        lblTitle.setForeground(new Color(41,128,185));
        
        JLabel welcome = new JLabel("Welcome to Quiz Management System");
        welcome.setBounds(0,170,650,25);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI",Font.PLAIN,17));
        welcome.setForeground(Color.GRAY);
        add(welcome);
        		
        btnViewQuiz = new JButton("View Quizzes");
        btnViewQuiz.setBounds(170,230,310,55);
        btnViewQuiz.setBackground(new Color(52,152,219));
        btnViewQuiz.setForeground(Color.WHITE);
        btnViewQuiz.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnViewQuiz.setFocusPainted(false);

        btnViewQuiz.setBorder(new LineBorder(new Color(41,128,185),2,true));
        btnViewQuiz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon view =
        		new ImageIcon("images/view.png");

        		Image viewImg =
        		view.getImage().getScaledInstance(
        		24,
        		24,
        		Image.SCALE_SMOOTH);

        		btnViewQuiz.setIcon(
        		new ImageIcon(viewImg));

        		btnViewQuiz.setHorizontalAlignment(
        		SwingConstants.LEFT);

        		btnViewQuiz.setIconTextGap(20);
        btnViewQuiz.addActionListener(e -> {

            new ViewQuizFrame(studentId);

            dispose();

        });

        btnTakeQuiz = new JButton("Take Quiz");
        btnTakeQuiz.setBounds(170,305,310,55);

        btnTakeQuiz.setBackground(
        new Color(46,204,113));

        btnTakeQuiz.setForeground(Color.WHITE);

        btnTakeQuiz.setFont(
        new Font("Segoe UI",Font.BOLD,16));

        btnTakeQuiz.setFocusPainted(false);

        btnTakeQuiz.setBorder(
        new LineBorder(
        new Color(39,174,96),
        2,
        true));

        btnTakeQuiz.setCursor(
        new Cursor(Cursor.HAND_CURSOR));
        ImageIcon take = new ImageIcon("images/take.png");
        Image takeImg = take.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
        btnTakeQuiz.setIcon(new ImageIcon(takeImg));
        btnTakeQuiz.setHorizontalAlignment(SwingConstants.LEFT);
        btnTakeQuiz.setIconTextGap(20);
        
        btnTakeQuiz.addActionListener(e -> {

            new AttemptQuizFrame(studentId);

            dispose();

        });

        btnViewScore = new JButton("View Score");
        btnViewScore.setBounds(170,380,310,55);
        btnViewScore.setBackground(new Color(155,89,182));
        btnViewScore.setForeground(Color.WHITE);
        btnViewScore.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnViewScore.setFocusPainted(false);
        btnViewScore.setBorder(new LineBorder(new Color(142,68,173),2,true));
        btnViewScore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ImageIcon score =new ImageIcon("images/viewscore.png");
        Image scoreImg = score.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
        btnViewScore.setIcon(new ImageIcon(scoreImg));
        btnViewScore.setHorizontalAlignment(SwingConstants.LEFT);
        btnViewScore.setIconTextGap(20);
        
        btnViewScore.addActionListener(e -> {

            new ViewScore(studentId);

            dispose();

        });

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(170,455,310,55);
        btnLogout.setBackground(new Color(231,76,60));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnLogout.setFocusPainted(false);
        btnLogout.setBorder(new LineBorder(new Color(192,57,43), 2,true));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ImageIcon logout = new ImageIcon("images/logout.png");
        Image logoutImg = logout.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
        btnLogout.setIcon(new ImageIcon(logoutImg));
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogout.setIconTextGap(20);

        add(lblTitle);
        add(btnViewQuiz);
        add(btnTakeQuiz);
        add(btnViewScore);
        add(btnLogout);


        // Logout
        btnLogout.addActionListener(e -> {

            new HomeFrame();

            dispose();

        });

        setVisible(true);
    }
}