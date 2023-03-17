package com.example.classes;

public class User {
    private String login;
    private String password;
    private String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User otherUser){
            if (obj == this) {
                return true;
            }
            return this.login.equals(otherUser.login) && this.password.equals(otherUser.password);
        } else {
            return false;
        }
    }
}
