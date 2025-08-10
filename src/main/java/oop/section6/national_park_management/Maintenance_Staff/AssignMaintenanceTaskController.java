package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AssignMaintenanceTaskController {

    @FXML
    private TableColumn<?, ?> issueDescriptionTableColumn;

    @FXML
    private TableColumn<?, ?> issueIdTableColumn;

    @FXML
    private TextField issueIdTextField;

    @FXML
    private TableColumn<?, ?> issueTypeTableColumn;

    @FXML
    private TableColumn<?, ?> locationTableColumn;

    @FXML
    private TableView<?> maintenceIssueTableView;

    @FXML
    private TableColumn<?, ?> priorityLevelTableColumn;

    @FXML
    private TextField searchKeyWordTextField;

    @FXML
    void assignToMeButton(ActionEvent event) {

    }

    @FXML
    void backToDashboardButton(ActionEvent event) {

    }

    @FXML
    void filterButton(ActionEvent event) {

    }

}
