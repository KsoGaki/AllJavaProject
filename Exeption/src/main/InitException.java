package main;

@SuppressWarnings("serial")
public class InitException extends Exception {
    public InitException(String message) {
        super("Init Error");
    }
}