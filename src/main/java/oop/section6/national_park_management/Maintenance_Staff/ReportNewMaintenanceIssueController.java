package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReportNewMaintenanceIssueController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<?, ?> issueDescriptionTableColumn;

    @FXML
    private TableColumn<?, ?> issueIdTableColumn;

    @FXML
    private ComboBox<?> issueTypeCombobox;

    @FXML
    private TableColumn<?, ?> issueTypeTableColumn;

    @FXML
    private TableColumn<?, ?> locationTableColumn;

    @FXML
    private TextField locationTextField;

    @FXML
    private TableView<?> maintenceIssueTableView;

    @FXML
    private ComboBox<?> priorityLevelCombobox;

    @FXML
    private TableColumn<?, ?> priorityLevelTableColumn;

    @FXML
    void backToDashboardButton(ActionEvent event) {

    }

    @FXML
    void submitIssueButton(ActionEvent event) {

    }

}
