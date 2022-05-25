package com.example.aplicatiepaypall;

import com.example.aplicatiepaypall.Blurr_Code.BlurrEfect;
import com.example.aplicatiepaypall.CPU.Gauss;
import com.example.aplicatiepaypall.CPU.IBenchmark;
import com.example.aplicatiepaypall.Timing.ITimer;
import com.example.aplicatiepaypall.Timing.Timer;
import com.example.aplicatiepaypall.logging.ConsoleLogger;
import com.example.aplicatiepaypall.logging.ILogger;
import com.example.aplicatiepaypall.logging.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPageImage implements Initializable {
    IBenchmark benchMark;
    ITimer timer;
    ILogger logger;
    TimeUnit timeUnit = TimeUnit.Mili;

    @FXML
    Button selectButton;

    @FXML
    Button timeList;

    @FXML
    Button deleteList;

    @FXML
    Button exitButton;

    FileChooser fileChooser = new FileChooser();
    String check = "";


    @FXML
    public void SelectFile() throws IOException {
        File file = fileChooser.showOpenDialog(new Stage());
        check = file.getAbsolutePath();
        Stage window = (Stage) selectButton.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if(check.charAt(check.length()-1) == 'g' && check.charAt(check.length()-2) == 'p' && check.charAt(check.length()-3) == 'j')
        {
            alert.setTitle("Confirmation");
            alert.setHeaderText("The image has been upload!");
            if (alert.showAndWait().get() == ButtonType.OK) ;
            BlurrEfect.initImage(check);

        }
        else
        {
            alert.setTitle("Confirmation");
            alert.setHeaderText("This is an invalid file!");
            alert.setContentText("Please choose a .jpg file!");
            if (alert.showAndWait().get() == ButtonType.OK) ;
        }

    }

    public void saveAction() throws IOException {
        if (!Objects.equals(check,"")) {
            String[] path = check.split("\\\\");
            String new_path = "";
            System.out.println(check);
            for (int i = 0; i < path.length - 1; i++) {
                System.out.println(path[i]);
                new_path = new_path + path[i] + "\\";
            }
            new_path = (String) new_path.subSequence(0, (int) (new_path.length() - 1));
            BlurrEfect.printOutput(new_path);
            System.out.println(new_path);
            Stage window = (Stage) selectButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation");
            alert.setHeaderText("The image has been saved!");
            if (alert.showAndWait().get() == ButtonType.OK) ;
        }
        else
        {
            Stage window = (Stage) selectButton.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong Input");
            alert.setHeaderText("Please select the input and blur the image!");
            if (alert.showAndWait().get() == ButtonType.OK) ;
        }
    }




    @FXML
    public void ExecTimeList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/table_view_image.fxml"));
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
            FileWriter myWriter = new FileWriter("filename1.txt");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void imageAction() throws IOException {
        long time;
        timer.start();
        BlurrEfect.CreateImage();
        time = timer.stop();
        try(FileWriter fw = new FileWriter("filename1.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println( "BlurImage " + logger.writeTime(time, timeUnit) + " " + "0");
        } catch (IOException e) {
        }
    }

    @FXML
    public void exitAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfataCo.fxml"));
        Parent root = (Parent) loader.load();
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.setTitle("Table");
        window.setScene(new Scene(root, 1280,720));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer = new Timer();
        logger = new ConsoleLogger();
        timeUnit = TimeUnit.Mili;
        benchMark = new Gauss();

        try {
            File myObj = new File("filename1.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        fileChooser.setInitialDirectory(new File("C:/Users/laure/Desktop"));
    }
}
