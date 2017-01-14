package javafortesters.chapter13.practice;


public class InvalidPassword extends RuntimeException {
    public InvalidPassword(String message) {
        super(message);
    }

}
