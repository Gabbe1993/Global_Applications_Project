package se.kth.iv1201projekt.exception;

/**
 * This exception should be thrown if an error occurred during registration.
 *
 * @author Kim
 */
public class RegisterErrorException extends Exception {

    public RegisterErrorException() {
        super();
    }

    public RegisterErrorException(String message) {
        super(message);
    }

    public RegisterErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
