package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewMaintenanceSuppliesController {

    @FXML
    private TableView<?> itemDataTableView;

    @FXML
    private TableColumn<?, ?> itemIdTableColumn;

    @FXML
    private TableColumn<?, ?> itemNameTableColumn;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TableColumn<?, ?> itemQuantityTableColumn;

    @FXML
    private TableColumn<?, ?> itemUrgencyLevelTableColumn;

    @FXML
    void backToDashboardButton(ActionEvent event) {

    }

    @FXML
    void searchButton(ActionEvent event) {

    }

}
