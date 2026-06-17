package quizmanagementsystem.model;

import java.util.Objects;

public class Attempt {
	private int attempt_id;
	private int quiz_id;
    private int student_id;
    private int score;
    
	public Attempt() {
		
	}
	
	public Attempt( int quiz_id, int student_id, int score) {
		super();
		
		this.quiz_id = quiz_id;
		this.student_id = student_id;
		this.score = score;
	}
	

	public int getAttempt_id() {
		return attempt_id;
	}

	public void setAttempt_id(int attempt_id) {
		this.attempt_id = attempt_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Attempt [quiz_id=" + quiz_id + ", student_id=" + student_id + ", score="
				+ score + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attempt_id, quiz_id, score, student_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attempt other = (Attempt) obj;
		return attempt_id == other.attempt_id && quiz_id == other.quiz_id && score == other.score
				&& student_id == other.student_id;
	}
	
	
}
