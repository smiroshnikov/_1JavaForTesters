package javafortesters.chapter13.practice;

// Runtime exceptions do not need to be described !
// Non runtime , those that extend exception need to be caught

public class InvalidPassword extends RuntimeException {
    public InvalidPassword(String message) {
        super(message);
    }

}
