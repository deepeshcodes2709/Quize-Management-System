package quizmanagementsystem.main;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import quizmanagementsystem.daoimpl.QuizDaoimpl;

public class QuestionFrame extends JFrame {
	
	private int studentId;
	private int quizId;

    JLabel lblQuestion;

    JRadioButton rbA;
    JRadioButton rbB;
    JRadioButton rbC;
    JRadioButton rbD;

    ButtonGroup bg;

    JButton btnNext;

    ResultSet rs;

    public QuestionFrame(int quizId, int studentId) {
    	
    	this.studentId = studentId;
    	this.quizId = quizId;

        setTitle("Quiz");

        setSize(700,500);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblQuestion = new JLabel();
        lblQuestion.setBounds(50,50,600,30);

        rbA = new JRadioButton();
        rbA.setBounds(50,120,500,30);

        rbB = new JRadioButton();
        rbB.setBounds(50,170,500,30);

        rbC = new JRadioButton();
        rbC.setBounds(50,220,500,30);

        rbD = new JRadioButton();
        rbD.setBounds(50,270,500,30);

        bg = new ButtonGroup();

        bg.add(rbA);
        bg.add(rbB);
        bg.add(rbC);
        bg.add(rbD);

        btnNext = new JButton("Next");
        btnNext.setBounds(280,350,120,35);
        btnNext.setBackground(new Color(52, 152, 219));
        btnNext.setForeground(Color.WHITE);
        btnNext.setFocusPainted(false);
        btnNext.setFont(new Font("Arial", Font.BOLD, 14));
        btnNext.setBorder(new LineBorder(new Color(41, 128, 185), 2, true));

        add(lblQuestion);
        add(rbA);
        add(rbB);
        add(rbC);
        add(rbD);
        add(btnNext);

        try {

            QuizDaoimpl qdao =
                    new QuizDaoimpl();

            rs =
                    qdao.getQuestions(quizId);

            loadQuestion();

        }

        catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage());

        }

        btnNext.addActionListener(e -> {

            try {

                if(rs.next()) {

                    lblQuestion.setText(
                            rs.getString("question_text"));

                    rbA.setText(
                            rs.getString("option_a"));

                    rbB.setText(
                            rs.getString("option_b"));

                    rbC.setText(
                            rs.getString("option_c"));

                    rbD.setText(
                            rs.getString("option_d"));

                    bg.clearSelection();

                }

                else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Quiz Finish");

                    new StudentDashboard(studentId);

                    dispose();
                }

            }

            catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());

            }

        });
        
        getContentPane().setBackground(new Color(245, 247, 250));

        setVisible(true);
    }

    private void loadQuestion() throws Exception {

        if(rs.next()) {

            lblQuestion.setText(
                    rs.getString("question_text"));

            rbA.setText(
                    rs.getString("option_a"));

            rbB.setText(
                    rs.getString("option_b"));

            rbC.setText(
                    rs.getString("option_c"));

            rbD.setText(
                    rs.getString("option_d"));
        }
    }
}