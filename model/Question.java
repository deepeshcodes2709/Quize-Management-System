package quizmanagementsystem.model;

public class Question {
	private String question;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private String OptionD;
	
	public Question() {
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return OptionA;
	}

	public void setOptionA(String optionA) {
		OptionA = optionA;
	}

	public String getOptionB() {
		return OptionB;
	}

	public void setOptionB(String optionB) {
		OptionB = optionB;
	}

	public String getOptionC() {
		return OptionC;
	}

	public void setOptionC(String optionC) {
		OptionC = optionC;
	}

	public String getOptionD() {
		return OptionD;
	}

	public void setOptionD(String optionD) {
		OptionD = optionD;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + ", OptionA=" + OptionA + ", OptionB=" + OptionB + ", OptionC="
				+ OptionC + ", OptionD=" + OptionD + "]";
	}
	
}
