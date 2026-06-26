package quizmanagementsystem.main;

import javax.swing.*;
import java.sql.ResultSet;

import quizmanagementsystem.daoimpl.QuizDaoimpl;

public class ViewResults extends JFrame {

    JTextArea taResults;
    JButton btnBack;

    public ViewResults() {

        setTitle("View Results");
        setSize(500,400);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taResults = new JTextArea();

        JScrollPane sp =
                new JScrollPane(taResults);

        sp.setBounds(20,20,450,250);

        btnBack = new JButton("Back");

        btnBack.setBounds(180,300,100,35);

        add(sp);
        add(btnBack);

        try {

            QuizDaoimpl qdao =
                    new QuizDaoimpl();

            ResultSet rs = qdao.getResults();
            
            String data = "";

            while(rs.next()) {

                data +=
                        "Student ID : "
                        + rs.getInt("student_id")
                        + "    Quiz ID : "
                        + rs.getInt("quiz_id")
                        + "    Score : "
                        + rs.getInt("score")
                        + "\n";
            }

            taResults.setText(data);

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