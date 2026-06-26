package quizmanagementsystem.main;

import javax.swing.*;
import java.util.Set;

import quizmanagementsystem.daoimpl.QuizDaoimpl;
import quizmanagementsystem.model.Quiz;

public class ViewQuizFrame extends JFrame {
	
	private int studentId;

    JTextArea txtArea;
    JButton btnBack;

    public ViewQuizFrame(int studentId) {
    	
    	this.studentId = studentId;

        setTitle("View Quizzes");
        setSize(500, 400);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtArea = new JTextArea();
        txtArea.setBounds(30, 30, 420, 250);

        btnBack = new JButton("Back");
        btnBack.setBounds(180, 300, 100, 35);

        add(txtArea);
        add(btnBack);

        try {

            QuizDaoimpl qdao = new QuizDaoimpl();

            Set<Quiz> quizzes = qdao.listQuiz();

            String data = "";

            for(Quiz q : quizzes) {

                data += "Quiz ID : " + q.getId()
                        + "    Title : "
                        + q.getTitle()
                        + "\n";
            }

            txtArea.setText(data);

        } catch(Exception e) {

            txtArea.setText(e.getMessage());
        }

        btnBack.addActionListener(e -> {

            new StudentDashboard(studentId);

            dispose();
        });

        setVisible(true);
    }
}