package com.example.classes;

import java.util.ArrayList;

public class ObjectStorage {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static User currentUser;

    static {
        users.add(new User("login", "password", "Fred"));
    }
    public static void loadClass(){}
}
