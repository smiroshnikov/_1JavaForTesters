package javafortesters.chapter21.practice;


public class SimpleUser {
    private String username;
    private String password;

    public SimpleUser() {
        this("defaultUsername", "defaultPassword");
    }

    public SimpleUser(String username, String password) {
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
        this.password = password;
    }
}
