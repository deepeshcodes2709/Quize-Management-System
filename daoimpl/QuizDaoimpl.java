package quizmanagementsystem.daoimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import quizmanagementsystem.Exception.NoQuestionsFoundException;
import quizmanagementsystem.Exception.QuizNotFoundException;
import quizmanagementsystem.model.Attempt;
import quizmanagementsystem.model.Quiz;
import quizmanagementsystem.model.User;
import quizmanagementsystem.util.DbUtil;

public class QuizDaoimpl {
	Connection con;
	Scanner sc = new Scanner(System.in);

	public QuizDaoimpl() throws Exception {
		con = DbUtil.getConnection();

	}

	public void create_quiz(String title, String path) throws Exception {
		String Query = "Insert into  quizzes(title ) values(?)";

		PreparedStatement stmt = con.prepareStatement(Query, PreparedStatement.RETURN_GENERATED_KEYS);

		stmt.setString(1, title);
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();

		int quizId = 0;
		if (rs.next()) {
			quizId = rs.getInt(1);
		}
//		System.out.println("generated key" + quizId);

		BufferedReader br = new BufferedReader(new FileReader(path));

		String Question;
		boolean Qfound = false;
		while ((Question = br.readLine()) != null) {
			if (Question.trim().isEmpty())
				continue;
			Qfound = true;
			String op_1 = br.readLine();
			String op_2 = br.readLine();
			String op_3 = br.readLine();
			String op_4 = br.readLine();
			String cor_op = br.readLine();

			String Query1 = "Insert into questions" + "(quize_id, question_text,option_a,option_b,"
					+ "option_c,option_d,correct_answer)" + "values(?,?,?,?,?,?,?)";

			PreparedStatement stmt1 = con.prepareStatement(Query1);
			stmt1.setInt(1, quizId);
			stmt1.setString(2, Question);
			stmt1.setString(3, op_1);
			stmt1.setString(4, op_2);
			stmt1.setString(5, op_3);
			stmt1.setString(6, op_4);
			stmt1.setString(7, cor_op);

			stmt1.executeUpdate();

			if (!Qfound) {
				throw new NoQuestionsFoundException("No QUESTION FOUND" + path);
			}
			System.out.println("Quiz is created ");
		}
	}

	public Set<Quiz> listQuiz() throws Exception {

		Set<Quiz> set = new LinkedHashSet<>();

		String sql = "SELECT * FROM quizzes";

		try (Statement stmt = con.createStatement()) {

			try (ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					Quiz q = new Quiz();
					q.setId(rs.getInt("quiz_id"));
					q.setTitle(rs.getString("title"));

					set.add(q);
				}
			}

			return set;
		}

	}
	
	public int deleteQuiz(int quiz_id) throws Exception{
		String sql = "delete from quizzes where quiz_id = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, quiz_id);
		
		int count = stmt.executeUpdate();
		
		if(count == 0) {
			throw new QuizNotFoundException("Quiz not found ");
		}
		
		return count;
		
	}
	
	public void viewResults() throws Exception{
		String sql = "select * from attempt";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		System.out.println("====== RESULTS ======");
		
		while(rs.next()) {
			System.out.println("Student Id: " + rs.getInt("student_Id"));
			
			System.out.println("Quiz Id: " + rs.getInt("quiz_id"));
			
			System.out.println(" Score : " + rs.getInt("score"));
			
			System.out.println("------------------------");
		}
	}
		public void attemptQuiz(int student_id, int quiz_id) throws Exception {
			int score=0;
			String sql ="select * from questions where quize_id = ? ";
					

			PreparedStatement stmt =
					con.prepareStatement(sql);
//			stmt.setInt(1, student_id);
			stmt.setInt(1, quiz_id);
			
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String que = rs.getString("question_text");
				if(que==null) {
					break;
				}
				
				System.out.println(que);
				System.out.println(rs.getString("option_a"));
				System.out.println(rs.getString("option_b"));
				System.out.println(rs.getString("option_c"));
				System.out.println(rs.getString("option_d"));
				
				System.out.println("enter your answer: ");
				String userAns = sc.next().trim().toUpperCase();
				String  correct_opt = rs.getString("correct_answer").trim();
				if(correct_opt.contains(":")) {
					correct_opt= correct_opt.split(":")[1].trim();
				}
					
				
				if(userAns.equalsIgnoreCase(correct_opt)) {
					System.out.println("correct ans ");
					score++;
				}
			}
			
			Attempt atmt = new Attempt(student_id, quiz_id, score);
			
			User u = new User();
			u.getAttemptmap().put(quiz_id, atmt);
			
			String sql1 = "insert into attempt(student_Id, quiz_Id, score) values(?,?,?)";
			
			PreparedStatement stmt3 =con.prepareStatement(sql1);
			
			stmt3.setInt(1, student_id);
			stmt3.setInt(2, quiz_id);
			stmt3.setInt(3, score);
			
			
			stmt3.executeUpdate();

			System.out.println("quiz submitted ");
			System.out.println("score" + score);
		
		}
		
	
		public void viewScore(int student_id) throws Exception {

		    String sql = "select * from attempt where student_id = ?";

		    PreparedStatement stmt = con.prepareStatement(sql);
		    stmt.setInt(1, student_id);

		    ResultSet rs = stmt.executeQuery();

		    boolean found = false;

		    while(rs.next()) {
		        found = true;

		        System.out.println("------------------");
		        System.out.println("Quiz Id : " + rs.getInt("quiz_id"));
		        System.out.println("Score   : " + rs.getInt("score"));
		    }

		    if(!found) {
		        System.out.println("No Quiz Attempted Yet");
		    }
		}
}
