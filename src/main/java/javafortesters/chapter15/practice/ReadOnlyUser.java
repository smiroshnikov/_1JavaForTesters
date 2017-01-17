package javafortesters.chapter15.practice;

// TODO redo all user assignments
// TODO this is interview candidate
public class ReadOnlyUser extends User {

    public ReadOnlyUser() {
        this("username", "password");
    }

    public ReadOnlyUser(String username, String password) {
        super(username, password);
    }

    public String getPermission() {
        return "read only";
    }
}
