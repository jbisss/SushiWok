package com.example.classes;

public class User {
    private final String login;
    private final String password;
    private final String name;
    private Card card;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Card getCard() {
        return card;
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

    public void setCard(Card card) {
        this.card = card;
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
