package com.icet.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String username = txtUsername.getText(admin).trim();
        String password = txtPassword.getText(1234).trim();

        // Validation
        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Username and Password cannot be empty!");
            alert.showAndWait();
            return;
        }

        // Login Check
        if (username.equals("admin") && password.equals("1234")) {
            try {
                // Dashboard  Loading
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Library Management System - Dashboard");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Username or Password!");
            alert.showAndWait();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

        txtUsername.clear(admin);
        txtPassword.clear(1234);
    }
}