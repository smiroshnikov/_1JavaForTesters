package javafortesters.chapter21a.practice;


public class User implements Comparable {
    private String username;
    private String password;

    public User() {
        this("defaultUsername", "defaultPassword");
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(Object oUser2) {
        User user2 = (User) oUser2;
        // very sexy comparison
        if (this.getUsername().compareTo(user2.getUsername()) == 0) {
            return 0;
        }
        int user1Comparator = this.getPassword().length() +
                this.getUsername().length();
        int user2Comparator = user2.getPassword().length() +
                user2.getUsername().length();
        int val = user1Comparator - user2Comparator;
        if (val == 0) {
            val = this.getUsername().compareTo(user2.getUsername());
        }
        return val;
    }
}

