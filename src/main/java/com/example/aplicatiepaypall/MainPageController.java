package com.example.aplicatiepaypall;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainPageController {

    @FXML
    Button computeButton;

    @FXML
    Button timeList;

    @FXML
    Button deleteList;

    @FXML
    Button exitButton;


    @FXML
    public void initComputations() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Page1.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) computeButton.getScene().getWindow();
        window.setTitle("Computation App");
        window.setScene(new Scene(root, 600,400));
    }

    @FXML
    public void ExecTimeList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/table_view.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) timeList.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,400));
    }

    @FXML
    public void deleteAction() {
        Stage window = (Stage) deleteList.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmation");
        alert.setHeaderText("The list has been deleted!");
        if (alert.showAndWait().get() == ButtonType.OK) ;

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void imageAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SelectToTest.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) timeList.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,400));
    }

    @FXML
    public void exitAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfataCo.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 1280,720));
    }

}
