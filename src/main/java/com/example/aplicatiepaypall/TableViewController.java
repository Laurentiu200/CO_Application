
package com.example.aplicatiepaypall;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TableViewController implements Initializable {

    @FXML
    private TableColumn<Runs, String> algorithm;

    @FXML
    Button back;
    @FXML
    private TableColumn<Runs, Integer> digits;

    @FXML
    private TableColumn<Runs, Double> execution;

    @FXML
    private TableColumn<Runs, Integer> score;

    @FXML
    private TableView<Runs> tabel;


    ObservableList<Runs> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                list.add(new Runs(myReader.nextInt(), myReader.next(),myReader.nextDouble(),myReader.nextInt()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        digits.setCellValueFactory(new PropertyValueFactory<Runs, Integer>("nr_digits"));
        algorithm.setCellValueFactory(new PropertyValueFactory<Runs, String>("algorithm"));
        execution.setCellValueFactory(new PropertyValueFactory<Runs, Double>("exec_time"));
        score.setCellValueFactory(new PropertyValueFactory<Runs, Integer>("score"));
        tabel.setItems(list);
    }

    @FXML
    public void backButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPage.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) back.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 600,600));
    }
}
