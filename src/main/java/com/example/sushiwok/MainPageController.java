package com.example.sushiwok;

import com.example.classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    public VBox vBoxMenu;
    public VBox vBoxBucket;
    public TextField finishCostField;
    public Button buyButton;
    public Label labelLog;
    public Label labelUser;
    public TextField fieldCardNumber;
    public TextField fieldCardPinCode;
    public AnchorPane back;
    public Button buttonBack;

    public void initialize(){
        BackgroundImage myBI= new BackgroundImage(new Image("bam.jpg",1200,750,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        back.setBackground(new Background(myBI));
        labelUser.setText(ObjectStorage.currentUser.getName());
        for(Product product : ObjectStorage.products){
            VBox vBox = new VBox();
            vBox.getChildren().add(product.getLabelName());
            vBox.getChildren().add(product.getImageView());
            vBox.getChildren().add(product.getButtonBuy());
            vBox.getChildren().add(product.getLabelCost());
            vBoxMenu.getChildren().add(vBox);
        }
        for(Product product:ObjectStorage.products){
            product.getButtonDelete().setOnAction(actionEvent -> {
                if(product.getAmount() == 1){
                    product.setAmount(0);
                    vBoxBucket.getChildren().remove(product.getVBox());
                    Bucket.bucketProducts.remove(product.getRemovableProduct());
                    finishCostField.setText(String.valueOf(Bucket.countBucket()));
                } else {
                    product.setAmount(product.getAmount() - 1);
                    String str = product.getAmount() + " * " + product.getCost() + " = " + product.getAmount() * product.getCost();
                    product.setLabelBucket(str);
                    finishCostField.setText(String.valueOf(Bucket.countBucket()));
                }
            });
            product.getButtonBuy().setOnAction(actionEvent -> {
                labelLog.setText("");
                if (product.getAmount() == 0) {
                    product.setRemovableProduct(product);
                    VBox vBox = new VBox();
                    vBox.getChildren().add(new Label(product.getLabelName().getText()));
                    ImageView newImageView = new ImageView(product.getImage());
                    newImageView.setFitHeight(150);
                    newImageView.setFitWidth(150);
                    vBox.getChildren().add(newImageView);
                    product.setAmount(1);
                    String str = product.getAmount() + " * " + product.getCost() + " = " + product.getAmount() * product.getCost();
                    product.setLabelBucket(str);
                    vBox.getChildren().add(product.getLabelBucketCost());
                    Bucket.addToBucket(product);
                    vBox.getChildren().add(product.getButtonDelete());
                    product.setVBox(vBox);
                    vBoxBucket.getChildren().add(vBox);
                    finishCostField.setText(String.valueOf(Bucket.countBucket()));
                } else {
                    product.setAmount(product.getAmount() + 1);
                    String str = product.getAmount() + " * " + product.getCost() + " = " + product.getAmount() * product.getCost();
                    product.setLabelBucket(str);
                    finishCostField.setText(String.valueOf(Bucket.countBucket()));
                }
            });
        }
    }


    public void buyButtonOnAction() {
        if(fieldCardNumber.getText().isEmpty() && fieldCardPinCode.getText().isEmpty()) {
            labelLog.setText("Заполните поля!");
        } else {
            Card card = CardHolder.findCard(Integer.parseInt(fieldCardNumber.getText()), Integer.parseInt(fieldCardPinCode.getText()));
            if(card != null){
                ObjectStorage.currentUser.setCard(card);
                int sum = Integer.parseInt(finishCostField.getText());
                if(sum <= ObjectStorage.currentUser.getCard().getMoney()){
                    labelLog.setText("Заказ сделан!");
                    ObjectStorage.currentUser.getCard().setMoney(ObjectStorage.currentUser.getCard().getMoney() - sum);
                    ObjectStorage.freeAmount();
                    vBoxBucket.getChildren().clear();
                    Bucket.bucketProducts.clear();
                    finishCostField.setText("");
                    fieldCardNumber.setText("");
                    fieldCardPinCode.setText("");
                } else {
                    labelLog.setText("Недостаточно средств!");
                }
            } else {
                labelLog.setText("Не найдено такой карты в базе!");
            }
        }
    }
    private void closeWindow(Button button){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hello-view.fxml"));
        LoaderFxml(loader);
        Stage stagePrev = (Stage) button.getScene().getWindow();
        stagePrev.hide();
    }
    private void LoaderFxml(FXMLLoader loader) {
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Меню");
        stage.show();
    }
    public void buttonBackOnAction() {
        closeWindow(buttonBack);
    }
}
