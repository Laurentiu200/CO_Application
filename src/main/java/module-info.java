module com.example.aplicatiepaypall {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.example.aplicatiepaypall to javafx.fxml;
    exports com.example.aplicatiepaypall;
    exports com.example.aplicatiepaypall.CPU;
    opens com.example.aplicatiepaypall.CPU to javafx.fxml;
}