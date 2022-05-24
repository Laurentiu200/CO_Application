package com.example.aplicatiepaypall;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgressAction implements Initializable {

    @FXML
    public ProgressIndicator progressRotation;

    double progress;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressRotation.indeterminateProperty();
    }
}
