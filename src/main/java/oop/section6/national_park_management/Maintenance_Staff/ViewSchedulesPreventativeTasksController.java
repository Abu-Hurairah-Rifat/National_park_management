package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewSchedulesPreventativeTasksController {

    @FXML
    private DatePicker endDateDatePicker;

    @FXML
    private TableColumn<?, ?> issueDescriptionTableColumn;

    @FXML
    private TableColumn<?, ?> issueIdTableColumn;

    @FXML
    private ComboBox<?> issueTypeComboBox;

    @FXML
    private TableColumn<?, ?> issueTypeTableColumn;

    @FXML
    private TableColumn<?, ?> locationTableColumn;

    @FXML
    private TextField locationTextField;

    @FXML
    private TableView<?> maintenceIssueTableView;

    @FXML
    private ComboBox<?> priorityLevelComboBox;

    @FXML
    private TableColumn<?, ?> priorityLevelTableColumn;

    @FXML
    private DatePicker startDateDatePicker;

    @FXML
    void backToDashboard(ActionEvent event) {

    }

    @FXML
    void filterButton(ActionEvent event) {

    }

}
