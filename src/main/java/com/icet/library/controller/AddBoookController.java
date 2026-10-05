package com.icet.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddBookController {

    @FXML private TextField txtIsbn;
    @FXML private TextField txtTitle;
    @FXML private TextField txtAuthor;
    @FXML private ComboBox<String> cmbCategory;
    @FXML private TextField txtYear;
    @FXML private TextField txtQuantity;

    @FXML
    public void initialize() {
        cmbCategory.setItems(FXCollections.observableArrayList("Fiction", "Technology", "Science", "History", "Novel"));
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        if (txtIsbn.getText().trim().isEmpty() || txtTitle.getText().trim().isEmpty() ||
                txtAuthor.getText().trim().isEmpty() || cmbCategory.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all required book details!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book added successfully!");
        alert.showAndWait();
        btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtIsbn.clear();
        txtTitle.clear();
        txtAuthor.clear();
        cmbCategory.getSelectionModel().clearSelection();
        txtYear.clear();
        txtQuantity.clear();
    }
}