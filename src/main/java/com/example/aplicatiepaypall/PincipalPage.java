package com.example.aplicatiepaypall;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;

public class PincipalPage {

    @FXML
    Button button;
    @FXML
    Button button2;
    @FXML
    Button more_info;

    @FXML
    public void DigitsOfPi() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPage.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) button.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,600));
    }

    @FXML
    public void ProcessingImage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPageImage.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) button2.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,600));
    }
//TODO
    @FXML
    public void InfoAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ceva.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) more_info.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,600));
    }
}
