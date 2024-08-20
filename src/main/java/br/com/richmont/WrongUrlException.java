package br.com.richmont;

public class WrongUrlException extends Exception {
    public WrongUrlException(String message) {
        super(message);
    }
}
