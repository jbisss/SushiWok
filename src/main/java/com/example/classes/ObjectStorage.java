package com.example.classes;

import java.util.ArrayList;

public class ObjectStorage {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static User currentUser;

    static {
        users.add(new User("login", "password", "Fred", CardHolder.cardHolder.get(0)));
    }
    static {
        products.add(new Product(450, "Филадельфия", "filadelfia.jpeg"));
        products.add(new Product(325, "Запеченый ролл Фудзияма", "fudzi.jpeg"));
        products.add(new Product(599, "Ролл с тунцом люкс", "lux.jpeg"));
        products.add(new Product(530, "Филадельфия с угрём и соусом", "ugrfila.jpeg"));
        products.add(new Product(399, "Запеченый ролл с тунцом", "yashimi.jpeg"));
        products.add(new Product(399, "Запеченый ролл Надзоми", "zapech.jpeg"));
    }
    public static void freeAmount(){
        for(Product product:ObjectStorage.products){
            product.setAmount(0);
        }
    }
    public static void loadClass(){}
}
