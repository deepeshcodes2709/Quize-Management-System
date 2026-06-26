package quizmanagementsystem.main;

import javax.swing.*;

import quizmanagementsystem.daoimpl.QuizDaoimpl;
import java.sql.ResultSet;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
public class AttemptQuizFrame extends JFrame {

    JLabel lblQuizId;

    JTextField txtQuizId;

    JButton btnStart;
    JButton btnBack;

    
    int studentId;

    public AttemptQuizFrame(int studentId) {
    	
    	getContentPane().setBackground(new Color(245, 247, 250));

        this.studentId = studentId;

        setTitle("Attempt Quiz");

        setSize(700,500);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblQuizId = new JLabel("Enter Quiz ID");

        lblQuizId.setBounds(50,30,120,30);
        
        lblQuizId.setFont(new Font("Arial", Font.BOLD, 16));
        lblQuizId.setForeground(new Color(44, 62, 80));

        txtQuizId = new JTextField();

        txtQuizId.setBounds(180,30,150,30);

        txtQuizId.setFont(new Font("Arial", Font.PLAIN, 15));

        txtQuizId.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(52,152,219),2,true),
                BorderFactory.createEmptyBorder(5,10,5,10)
            )
        );
        
        btnStart = new JButton("Start Quiz");
        btnStart.setBounds(350,30,120,30);

        btnStart.setBackground(new Color(46, 204, 113));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFont(new Font("Arial", Font.BOLD, 14));
        btnStart.setFocusPainted(false);
        btnStart.setBorder(new LineBorder(
                new Color(39,174,96),2,true));

        btnBack = new JButton("Back");
        btnBack.setBounds(250,350,120,35);
        
        btnBack.setBackground(new Color(231, 76, 60));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setFocusPainted(false);
        btnBack.setBorder(new LineBorder(
                new Color(192,57,43),2,true));

        add(lblQuizId);
        add(txtQuizId);

        add(btnStart);
        add(btnBack);
        
        JLabel heading = new JLabel("Attempt Quiz");

        heading.setBounds(250,70,250,40);

        heading.setFont(new Font("Arial", Font.BOLD, 24));

        heading.setForeground(new Color(52,152,219));

        add(heading);


        btnStart.addActionListener(e -> {
        	
        	 try {

        	        int quizId =
        	                Integer.parseInt(
        	                        txtQuizId.getText());

        	        new QuestionFrame(
        	                quizId,
        	                studentId);

        	        dispose();

        	    }

//        	 try {
//
//                 int quizId =
//                         Integer.parseInt(
//                                 txtQuizId.getText());
//
//                 QuizDaoimpl qdao =
//                         new QuizDaoimpl();
//
//                 ResultSet rs =
//                         qdao.getQuestions(quizId);
//
//                 if(rs.next()) {
//                	 
//                	 lblQuizId.setVisible(false);
//
//                	 txtQuizId.setVisible(false);
//
//                	 btnStart.setVisible(false);
//                	 
//                	 btnNext.setVisible(true);
//
//                     lblQuestion.setText(
//                             rs.getString("question_text"));
//
//                     rbA.setText(
//                             rs.getString("option_a"));
//
//                     rbB.setText(
//                             rs.getString("option_b"));
//
//                     rbC.setText(
//                             rs.getString("option_c"));
//
//                     rbD.setText(
//                             rs.getString("option_d"));
//
//                 }
//                 else {
//
//                     JOptionPane.showMessageDialog(
//                             null,
//                             "No Questions Found");
//
//                 }
//        	 }

            catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());

            }

        });

        btnBack.addActionListener(e -> {

            new StudentDashboard(studentId);

            dispose();

        });

        setVisible(true);
    }
}