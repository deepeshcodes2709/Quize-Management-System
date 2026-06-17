package quizmanagementsystem.Exception;

public class NoQuestionsFoundException extends Exception {

    public NoQuestionsFoundException() {
        super("No questions found!");
    }

    public NoQuestionsFoundException(String message) {
        super(message);
    }
}