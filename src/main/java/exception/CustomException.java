package exception;

public abstract class CustomException extends Exception {

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
