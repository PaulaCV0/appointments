package com.example.demo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class AppHardWay extends Application {

    public static void main (String [] args) {
        launch(args);
    }

    public void start (Stage stage) {
        TextField txtName = new TextField();
        PasswordField txtPassword = new PasswordField();
        Label lblWelcome = new Label("Please enter your credentials: ");

        HBox namePane = new HBox(5);
        namePane.getChildren().add(new Label("Name: "));
        namePane.getChildren().add(txtName);

        HBox passwordPane = new HBox(5);
        passwordPane.getChildren().add(new Label("Password: "));
        passwordPane.getChildren().add(txtPassword);

        CheckBox monday = new CheckBox("Monday");
        CheckBox tuesday = new CheckBox("Tuesday");
        CheckBox wednesday = new CheckBox("Wednesday");

        HBox dayPane= new HBox(5); // creates box
        dayPane.getChildren().add(new Label ("Availability: ")); // explains/asks
        dayPane.getChildren().add(monday);// option 1
        dayPane.getChildren().add(tuesday);// option 2
        dayPane.getChildren().add(wednesday);// option 3

        Button loginButton = new Button ("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = txtName.getText();
                String password = txtPassword.getText();
                lblWelcome.setText("Welcome " + name + "!");
                txtName.clear();
                txtPassword.clear();

                if (monday.isSelected()) {
                    lblWelcome.setText("Welcome " + name + "! Monday reserved");
                } else if (tuesday.isSelected()) {
                    lblWelcome.setText("Welcome " + name + "! Tuesday reserved");
                }else if (wednesday.isSelected()){
                lblWelcome.setText("Welcome " + name + "! Wednesday reserved");
                }
            }
        });

        VBox layout = new VBox(20);
        layout.getChildren().add(lblWelcome);
        layout.getChildren().add(namePane);
        layout.getChildren().add(passwordPane);
        layout.getChildren().add(dayPane); // adding the check box + options into the vertical box
        layout.getChildren().add(loginButton);

        Scene scene = new Scene (layout, 600, 250);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

}
