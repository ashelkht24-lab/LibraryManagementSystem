package com.icet.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class IssueBookController {

    @FXML private ComboBox<String> cmbMember;
    @FXML private ComboBox<String> cmbBook;
    @FXML private DatePicker dpIssueDate;
    @FXML private DatePicker dpDueDate;

    @FXML
    public void initialize() {
        cmbMember.setItems(FXCollections.observableArrayList("M001 - John Perera", "M002 - Kamal Silva"));
        cmbBook.setItems(FXCollections.observableArrayList("B001 - JavaFX Basics", "B002 - Python Guide"));
    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {
        if (cmbMember.getValue() == null || cmbBook.getValue() == null ||
                dpIssueDate.getValue() == null || dpDueDate.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select Member, Book, and Dates!");
    s        alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Issued Successfully!");
        alert.showAndWait();
    }
}s