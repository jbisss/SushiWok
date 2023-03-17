package com.example.classes;

import javafx.scene.image.Image;

public class Product {
    private int cost;
    private String name;
    private Image image;

    public Product(int cost, String name, Image image) {
        this.cost = cost;
        this.name = name;
        this.image = image;
    }

    public int getCost() {
        return cost;
    }
    public String getName() {
        return name;
    }
    public Image getImage() {
        return image;
    }
}
