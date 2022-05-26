package com.example.aplicatiepaypall;

import com.example.aplicatiepaypall.CPU.BrentSalamin;
import com.example.aplicatiepaypall.CPU.Gauss;
import com.example.aplicatiepaypall.CPU.IBenchmark;
import com.example.aplicatiepaypall.CPU.PiSpigot;
import com.example.aplicatiepaypall.Timing.ITimer;
import com.example.aplicatiepaypall.Timing.Timer;
import com.example.aplicatiepaypall.logging.ConsoleLogger;
import com.example.aplicatiepaypall.logging.ILogger;
import com.example.aplicatiepaypall.logging.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

import java.io.IOException;

public class HelloController {

    IBenchmark benchMark;
    ITimer timer;
    ILogger logger;
    TimeUnit timeUnit = TimeUnit.Sec;


    @FXML
    TextField textField;
    @FXML
    TextField scoreField;
    @FXML
    TextField digitsOfPi;
    @FXML
    Button gaussButton;
    @FXML
    Button backButton;
    @FXML
    ProgressIndicator progress;

    @FXML
    public void initialize() {
        progress.setVisible(false);
        timer = new Timer();
        logger = new ConsoleLogger();
        timeUnit = TimeUnit.Mili;
        benchMark = new Gauss();

        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        benchMark.initialize(1000);
        benchMark.Run(0);
    }

    @FXML
    public void backAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPage.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,600));
    }


    @FXML
    public void computeGauss() {

        if (textField.getText() != "") {

            benchMark.initialize(Integer.parseInt(textField.getText()));
            long time;
            progress.setVisible(true);
            timer.start();
            for(int i = 1; i <= 50; i++)
            benchMark.Run(0);
            time = timer.stop();
            digitsOfPi.setText(benchMark.getResult());
            progress.setVisible(true);
            scoreField.setText(String.valueOf(50.0/Math.sqrt(time/1000000000.0)));
            try(FileWriter fw = new FileWriter("filename.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(textField.getText() + " " + "Gauss " + logger.writeTime(time, timeUnit) + " " + "0");
            } catch (IOException e) {
            }

        } else {
            Stage window = (Stage) gaussButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Enter the number of digits!");
            alert.setContentText("You have to enter an integer number! ");
            if (alert.showAndWait().get() == ButtonType.OK) ;


        }


    }

    @FXML
    public void Brent() {
        BrentSalamin alg = new BrentSalamin(Integer.parseInt(textField.getText()) - 3);
        if (textField.getText() != "") {
            benchMark.initialize(Integer.parseInt(textField.getText()));
            timer.start();
            for (int i = 1; i <= 100; i++)
                alg.computeImpl();
            long time = timer.stop();
            digitsOfPi.setText("PI = " + String.valueOf(alg.computeImpl()));
            scoreField.setText(String.valueOf(Math.sqrt((100.0/(time/1000000000.0)))));

            try(FileWriter fw = new FileWriter("filename.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(textField.getText() + " " + "Brent " + logger.writeTime(time, timeUnit) + " " + "0");
            } catch (IOException e) {
            }
        } else {
            Stage window = (Stage) gaussButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Enter the number of digits!");
            alert.setContentText("You have to enter an integer number! ");
            if (alert.showAndWait().get() == ButtonType.OK) ;


        }
    }

    @FXML
    public void spigot() {
        String result = "";
        if (textField.getText() != "") {
            benchMark.initialize(Integer.parseInt(textField.getText()));
            timer.start();
            for(int i = 1 ; i <= 100; i++ )
            benchMark.Run(1);
            long time = timer.stop();
            digitsOfPi.setText(PiSpigot.getAllDigits());
            scoreField.setText(String.valueOf(Math.sqrt((100.0/(time/1000000000.0)))));
            try (FileWriter fw = new FileWriter("filename.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(textField.getText() + " " + "Spigot " + logger.writeTime(time, timeUnit) + " " + "0");
            } catch (IOException e) {
            }
        } else {
            Stage window = (Stage) gaussButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Enter the number of digits!");
            alert.setContentText("You have to enter an integer number! ");
            if (alert.showAndWait().get() == ButtonType.OK) ;


        }
    }
}