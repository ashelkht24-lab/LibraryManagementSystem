package com.icet.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddMemberController {

    @FXML private TextField txtMemberId;
    @FXML private TextField txtFullName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtPhone;
    @FXML private TextField txtAddress;

    @FXML
    void btnRegisterMemberOnAction(ActionEvent event) {
        if (txtMemberId.getText().trim().isEmpty() || txtFullName.getText().trim().isEmpty() || txtPhone.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Member ID, Name, and Phone number are required!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Member Registered Successfully!");
        alert.showAndWait();
        btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtMemberId.clear();
        txtFullName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtAddress.clear();
    }
}