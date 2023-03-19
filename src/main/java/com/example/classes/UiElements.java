package com.example.classes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class UiElements {
    private Image image;
    private final Button buttonBuy = new Button("Добавить в корзину");
    private final Button buttonDelete = new Button("Удалить из корзины");
    private final Label labelName = new Label();
    private final Label labelCost = new Label();
    private final Label labelBucketCost = new Label();
    private VBox vBox;

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public VBox getvBox() {
        return vBox;
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }

    public Label getLabelBucketCost() {
        return labelBucketCost;
    }

    public void setLabelBucketCost(String text){
        labelBucketCost.setText(text);
    }
    public void setLabelCost(String text){
        this.labelCost.setText(text);
    }
    public Label getLabelCost() {
        return labelCost;
    }

    private ImageView imageView;

    public void setImage(String image) {
        this.image = new Image(image);
    }

    public void setLabelName(String text) {
        this.labelName.setText(text);
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setFitWidth(150);
        this.imageView.setFitHeight(150);
    }

    public Image getImage() {
        return image;
    }

    public Button getButtonBuy() {
        return buttonBuy;
    }

    public Label getLabelName() {
        return labelName;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
