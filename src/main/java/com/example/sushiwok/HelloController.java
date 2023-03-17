package com.example.sushiwok;

import com.example.classes.ObjectStorage;
import com.example.classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Button enterButton;
    public Button registrButton;
    public TextField enterLogin;
    public TextField enterPassword;
    public TextField registrLogin;
    public TextField registrPassword;
    public TextField registrName;
    public Label labelLog;
    public Button doneRegistrButton;
    public void doneRegistrButtonOnAction() {
        if(!(registrLogin.getText().isEmpty() && registrName.getText().isEmpty() && registrPassword.getText().isEmpty())){
            ObjectStorage.users.add(new User(registrLogin.getText(), registrPassword.getText(), registrName.getText()));
            closeWindow(enterButton, "main-page.fxml");
        } else {
            labelLog.setText("Invalid input!");
        }
    }

    public void initialize(){
        ObjectStorage.loadClass();
    }
    public void enterButtonOnAction() {
        if(!(enterLogin.getText().isEmpty() && enterPassword.getText().isEmpty())) {
            String login = enterLogin.getText();
            String password = enterPassword.getText();
            for(User user : ObjectStorage.users){
                if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                    ObjectStorage.currentUser = user;
                }
            }
            if(ObjectStorage.currentUser == null) {
                labelLog.setText("User doesn't exist!");
            } else {
                closeWindow(enterButton, "main-page.fxml");
            }
        } else {
            labelLog.setText("Invalid input!");
        }
    }

    public void registrButtonOnAction() {
        Stage stagePrev = (Stage) enterButton.getScene().getWindow();
        stagePrev.setHeight(360);
    }
    private void closeWindow(Button button, String file){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(file));
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
        stage.setTitle("Фильмы");
        stage.show();
    }


}