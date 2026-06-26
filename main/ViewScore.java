package quizmanagementsystem.main;

import javax.swing.*;
import java.sql.ResultSet;

import quizmanagementsystem.daoimpl.QuizDaoimpl;

public class ViewScore extends JFrame {

	private int studentId;
	
    JTextArea taScore;
    JButton btnBack;

    public ViewScore(int studentId) {
    	
    	this.studentId = studentId;

        setTitle("View Score");
        setSize(500,400);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taScore = new JTextArea();

        JScrollPane sp = new JScrollPane(taScore);

        sp.setBounds(20,20,440,250);

        btnBack = new JButton("Back");
        btnBack.setBounds(180,300,100,35);

        add(sp);
        add(btnBack);

        try {

            QuizDaoimpl qdao = new QuizDaoimpl();

            ResultSet rs = qdao.getStudentScore(studentId);

            String data = "";

            while(rs.next()) {

                data +=
                        "Quiz ID : "
                        + rs.getInt("quiz_id")
                        + "    Score : "
                        + rs.getInt("score")
                        + "\n";
            }

            if(data.isEmpty()) {

                taScore.setText("No Quiz Attempted");

            } else {

                taScore.setText(data);

            }

        }

        catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage());

        }

        btnBack.addActionListener(e -> {

            new StudentDashboard(studentId);

            dispose();

        });

        setVisible(true);
    }
}