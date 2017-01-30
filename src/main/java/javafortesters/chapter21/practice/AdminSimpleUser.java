package javafortesters.chapter21.practice;

public class AdminSimpleUser extends SimpleUser {
    public AdminSimpleUser() {
        super("Admin", "p4ZZw0rd");
    }

    public AdminSimpleUser(String username, String password) {
        super(username, password);
    }
}
