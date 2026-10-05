package com.icet.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane contentArea;

    @FXML
    public void initialize() {
        // Dashboard එක Open වන විටම මුලින්ම Statistics Cards View එක Load කිරීම
        navigateTo("DashboardView.fxml");
    }

    // Dynamic Navigation Method
    public void navigateTo(String fxmlFile) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("/view/" + fxmlFile));
            contentArea.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        navigateTo("DashboardView.fxml");
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        navigateTo("AddBook.fxml");
    }

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {
        navigateTo("AddMember.fxml");
    }

    @FXML
    void btnManageMembersOnAction(ActionEvent event) {
        navigateTo("ManageMembers.fxml");
    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {
        navigateTo("IssueBook.fxml");
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
        navigateTo("ReturnBook.fxml");
    }

    @FXML
    void btnBorrowHistoryOnAction(ActionEvent event) {
        navigateTo("BorrowingHistory.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Library Management System - Login");
        stage.show();
    }
}

