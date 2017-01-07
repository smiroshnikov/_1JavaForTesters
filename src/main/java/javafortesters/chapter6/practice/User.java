package javafortesters.chapter6.practice;

public class User {

    public final static int MINIMAL_PASSWORD_LENGTH = 12;
    private String username;
    private String password;

    public User() {
        //this.username = "username";
        //this.password = "password";
        this("username", "password");
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
