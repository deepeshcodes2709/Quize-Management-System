package quizmanagementsystem.main;

import javax.swing.*;

import quizmanagementsystem.daoimpl.QuizDaoimpl;

public class CreateQuiz extends JFrame {

    public CreateQuiz() {

        setTitle("Create Quiz");
        setSize(500,400);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblTitle = new JLabel("Quiz Title");
        lblTitle.setBounds(80,100,100,30);

        JTextField txtTitle = new JTextField();
        txtTitle.setBounds(200,100,200,30);

        JLabel lblPath = new JLabel("File Path");
        lblPath.setBounds(80,150,100,30);

        JTextField txtPath = new JTextField();
        txtPath.setBounds(200,150,200,30);

        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(120,250,100,35);
        btnCreate.addActionListener(e -> {

            try {

                String title = txtTitle.getText();
                String path = txtPath.getText();

                QuizDaoimpl qdao = new QuizDaoimpl();

                qdao.create_quiz(title, path);

                JOptionPane.showMessageDialog(null,
                        "Quiz Created Successfully");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null,
                        ex.getMessage());

            }

        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250,250,100,35);

        btnBack.addActionListener(e -> {

            new AdminDashboard();

            dispose();

        });

        add(lblTitle);
        add(txtTitle);
        add(lblPath);
        add(txtPath);
        add(btnCreate);
        add(btnBack);

        setVisible(true);
    }
}