package javafortesters.chapter12.practice;

import javafortesters.chapter6.practice.User;

public class ReadOnlyUser extends User {
    @Override
    public String getPermission() {
        return "ReadOnly";
    }
}
