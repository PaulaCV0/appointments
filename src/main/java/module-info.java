module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports Registration;
    opens Registration to javafx.fxml;
}