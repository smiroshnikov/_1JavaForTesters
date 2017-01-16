package javafortesters.chapter15.practice;

public class User {
    String username;
    String password;


    public User() {
        // no arguments - default values
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

    public String getPermission() {
        return "normal";
    }
}
