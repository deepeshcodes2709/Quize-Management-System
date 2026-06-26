package quizmanagementsystem.main;

import javax.swing.*;
import java.util.Set;

import quizmanagementsystem.daoimpl.QuizDaoimpl;
import quizmanagementsystem.model.Quiz;

public class ListQuizFram extends JFrame {

    JTextArea taQuiz;
    JButton btnBack;

    public ListQuizFram() {

        setTitle("List Quizzes");
        setSize(500,400);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taQuiz = new JTextArea();

        JScrollPane sp =
                new JScrollPane(taQuiz);

        sp.setBounds(30,30,420,250);

        btnBack = new JButton("Back");
        btnBack.setBounds(180,300,100,35);

        add(sp);
        add(btnBack);

        try {

            QuizDaoimpl qdao =
                    new QuizDaoimpl();

            Set<Quiz> quizzes =
                    qdao.listQuiz();

            String data = "";

            for(Quiz q : quizzes) {

                data +=
                        "Quiz ID : "
                        + q.getId()
                        + "    Title : "
                        + q.getTitle()
                        + "\n";

            }

            taQuiz.setText(data);

        }

        catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage());

        }

        btnBack.addActionListener(e -> {

            new AdminDashboard();

            dispose();

        });

        setVisible(true);
    }
}