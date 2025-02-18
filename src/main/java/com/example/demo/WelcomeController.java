package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WelcomeController {
    @FXML
    private TextField txtName;

    @FXML
    private Label lblWelcome;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private CheckBox monday;

    @FXML
    private void onButtonClicked () {
        String name = txtName.getText();
        String password = txtPassword.getText();
        lblWelcome.setText("Welcome " + name + "!");
        txtName.clear();
        txtPassword.clear();

        if (monday.isSelected()) {
            lblWelcome.setText("Welcome " + name + "! Monday reserved");
        } else {
            lblWelcome.setText("Welcome " + name + "!");
        }
    }
}
