package com.example.classes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Product {
    private final int cost;
    private int amount = 0;
    private Product removableProduct;

    public Product getRemovableProduct() {
        return removableProduct;
    }

    public void setRemovableProduct(Product removableProduct) {
        this.removableProduct = removableProduct;
    }

    public VBox getVBox(){
        return elements.getvBox();
    }
    public void setVBox(VBox vBox){
        elements.setvBox(vBox);
    }

    public UiElements elements = new UiElements();

    public Product(int cost, String name, String image) {
        this.cost = cost;
        elements.setImage(image);
        elements.setImageView(new ImageView(image));
        elements.setLabelName(name);
        elements.setLabelCost(String.valueOf(cost));
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setLabelBucket(String text){
        elements.setLabelBucketCost(text);
    }
    public Label getLabelBucketCost(){
        return elements.getLabelBucketCost();
    }
    public Button getButtonDelete(){
        return elements.getButtonDelete();
    }
    public int getCost() {
        return cost;
    }
    public Image getImage() {
        return elements.getImage();
    }
    public Label getLabelName(){
        return elements.getLabelName();
    }
    public Label getLabelCost(){
        return elements.getLabelCost();
    }

    public Button getButtonBuy() {
        return elements.getButtonBuy();
    }

    public ImageView getImageView() {
        return elements.getImageView();
    }
}
