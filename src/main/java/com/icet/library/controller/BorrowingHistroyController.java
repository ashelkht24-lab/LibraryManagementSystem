package com.icet.library.controller;

import com.icet.library.model.BorrowRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BorrowingHistoryController {

    @FXML private TableView<BorrowRecord> tblHistory;
    @FXML private TableColumn<BorrowRecord, String> colMemberId;
    @FXML private TableColumn<BorrowRecord, String> colBookTitle;
    @FXML private TableColumn<BorrowRecord, String> colIssueDate;
    @FXML private TableColumn<BorrowRecord, String> colDueDate;
    @FXML private TableColumn<BorrowRecord, String> colReturnDate;
    @FXML private TableColumn<BorrowRecord, String> colStatus;

    @FXML
    public void initialize() {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<BorrowRecord> historyList = FXCollections.observableArrayList(
                new BorrowRecord("M001", "JavaFX Pro", "2026-09-01", "2026-09-10", "2026-09-08", "Returned"),
                new BorrowRecord("M002", "Python Guide", "2026-09-15", "2026-09-22", "-", "Overdue"),
                new BorrowRecord("M001", "Database Systems", "2026-10-01", "2026-10-08", "-", "Borrowed")
        );

        tblHistory.setItems(historyList);
    }
}