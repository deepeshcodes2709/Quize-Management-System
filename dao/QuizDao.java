package quizmanagementsystem.dao;

import java.util.Set;

import quizmanagementsystem.model.Quiz;

public interface QuizDao {
	public void create_quiz(String title, String path)throws Exception;
	Set<Quiz> listQuiz() throws Exception;
	void viewResults() throws Exception;
	void attemptQuiz(int quizId) throws Exception;
	void viewScore(int student_id) throws Exception;
}
