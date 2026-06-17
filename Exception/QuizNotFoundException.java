package quizmanagementsystem.Exception;


public class QuizNotFoundException extends Exception {

    public QuizNotFoundException() {
        super("Quiz not found!");
    }

    public QuizNotFoundException(String message) {
        super(message);
    }
}