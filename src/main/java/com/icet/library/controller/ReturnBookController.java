package com.icet.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReturnBookController {

    @FXML private ComboBox<String> cmbBorrowedBook;
    @FXML private Label lblMemberInfo;
    @FXML private Label lblBorrowedDate;
    @FXML private Label lblDueDate;
    @FXML private Label lblOverdueStatus;
    @FXML private DatePicker dpReturnDate;

    @FXML
    public void initialize() {
        cmbBorrowedBook.setItems(FXCollections.observableArrayList("B001 - JavaFX Basics (Issued to M001)"));
    }

    @FXML
    void btnSearchBookOnAction(ActionEvent event) {
        if (cmbBorrowedBook.getValue() != null) {
            lblMemberInfo.setText("M001 - John Perera");
            lblBorrowedDate.setText("2026-09-20");
            lblDueDate.setText("2026-09-27");
            lblOverdueStatus.setText("OVERDUE (3 Days)");
            lblOverdueStatus.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
        if (dpReturnDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select the Return Date!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Returned Successfully!");
        alert.showAndWait();
    }
}
