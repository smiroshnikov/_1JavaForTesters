package javafortesters.chapter15.practice;

// TODO redo all user assignments
// TODO this is interview candidate

public class AdminUser extends User {

    public AdminUser() {
        super("admin", "p4ssw0r6!");
    }

    public AdminUser(String user, String password) {
        super(user, password);
    }

    public String getPermission() {
        return "elevated";
    }

}
