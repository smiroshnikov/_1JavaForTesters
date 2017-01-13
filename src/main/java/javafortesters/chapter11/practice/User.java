package javafortesters.chapter11.practice;

public class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // lets keep it for the sake of the example
        // exceptions are not intended for validations
        if (password.length() < 7) {
            throw new IllegalArgumentException("Password must be 7 characters at least !");
        }
        this.password = password;
    }
}
