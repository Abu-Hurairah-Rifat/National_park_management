package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MaintenanceWorkLogsController {

    @FXML
    private TableColumn<?, ?> detailsOfWorkPerformedTableColumn;

    @FXML
    private TextArea detailsOfWorkPerformedTextArea;

    @FXML
    private DatePicker endDateDatepicker;

    @FXML
    private TableColumn<?, ?> endTimeTableColumn;

    @FXML
    private TableColumn<?, ?> issueIdTableColumn;

    @FXML
    private TextField issueIdTextField;

    @FXML
    private TableView<?> recordWorkLogTableView;

    @FXML
    private DatePicker startDateDatepicker;

    @FXML
    private TableColumn<?, ?> startTimeTableColumn;

    @FXML
    void backToDashboardButton(ActionEvent event) {

    }

    @FXML
    void saveLogButton(ActionEvent event) {

    }

}
