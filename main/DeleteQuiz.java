package quizmanagementsystem.main;

import javax.swing.*;

import quizmanagementsystem.daoimpl.QuizDaoimpl;

public class DeleteQuiz extends JFrame {

    JLabel lblQuizId;

    JTextField txtQuizId;

    JButton btnDelete;
    JButton btnBack;

    public DeleteQuiz() {

        setTitle("Delete Quiz");

        setSize(500,300);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblQuizId = new JLabel("Enter Quiz ID");

        lblQuizId.setBounds(80,80,120,30);

        txtQuizId = new JTextField();

        txtQuizId.setBounds(220,80,150,30);

        btnDelete = new JButton("Delete");

        btnDelete.setBounds(100,180,120,35);

        btnBack = new JButton("Back");

        btnBack.setBounds(250,180,120,35);

        add(lblQuizId);
        add(txtQuizId);

        add(btnDelete);
        add(btnBack);

        btnDelete.addActionListener(e -> {

            try {

                int quizId =
                        Integer.parseInt(
                                txtQuizId.getText());

                QuizDaoimpl qdao =
                        new QuizDaoimpl();

                qdao.deleteQuiz(quizId);

                JOptionPane.showMessageDialog(
                        null,
                        "Quiz Deleted Successfully");

            }

            catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());

            }

        });

        btnBack.addActionListener(e -> {

            new AdminDashboard();

            dispose();

        });

        setVisible(true);
    }
}