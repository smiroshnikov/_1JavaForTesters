package javafortesters.chapter6.practice;

import javafortesters.chapter13.practice.InvalidPassword;
import javafortesters.chapter5.practice.TestAppEnv;

public class User {

    public final static int MINIMAL_PASSWORD_LENGTH = 12;
    public final static int MAXIMUM_PASSWORD_LENGTH = 21;


    private String username;
    private String password;


    public User() {
        //this.username = "username";
        //this.password = "password";
        // constructor from constructor
        // constructor without arguments
        this("username", "password");
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
        //this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 7) {
            throw new InvalidPassword("Password must be 7 chars at least !");
        }
        this.password = password;
    }

    public static User[] createUsers(int desiredNumberOfUsers) {
        User[] users;
        users = new User[desiredNumberOfUsers];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User("username" + (i + 1), "password" + (i + 1));
        }
        return users;
    }

    public String getUrl() {
        return TestAppEnv.getUrl();
    }

    public String getPermission() {
        return "Normal";
    }
}
