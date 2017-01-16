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
        setPassword(password);
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

    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IncorrectPasswordException("password too short!");
        }
        this.password = password;
    }
}
