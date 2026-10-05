package com.icet.library.controller;

import com.icet.library.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageMembersController {

    @FXML private TextField txtSearch;
    @FXML private TableView<Member> tblMembers;
    @FXML private TableColumn<Member, String> colId;
    @FXML private TableColumn<Member, String> colName;
    @FXML private TableColumn<Member, String> colEmail;
    @FXML private TableColumn<Member, String> colPhone;
    @FXML private TableColumn<Member, String> colAddress;

    private ObservableList<Member> memberList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Dummy Data for Demonstration
        memberList.add(new Member("M001", "John Perera", "john@gmail.com", "0771234567", "Colombo"));
        memberList.add(new Member("M002", "Kamal Silva", "kamal@gmail.com", "0719876543", "Kandy"));
        tblMembers.setItems(memberList);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String query = txtSearch.getText().trim().toLowerCase();
        if (query.isEmpty()) {
            tblMembers.setItems(memberList);
            return;
        }
        ObservableList<Member> filtered = FXCollections.observableArrayList();
        for (Member m : memberList) {
            if (m.getName().toLowerCase().contains(query) || m.getId().toLowerCase().contains(query)) {
                filtered.add(m);
            }
        }
        tblMembers.setItems(filtered);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Member selected = tblMembers.getSelectionModel().getSelectedItem();
        if (selected != null) {
            memberList.remove(selected);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Member deleted successfully!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a member to delete!");
            alert.showAndWait();
        }
    }
}