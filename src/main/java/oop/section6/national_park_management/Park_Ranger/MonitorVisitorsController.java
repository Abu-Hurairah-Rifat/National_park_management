package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class MonitorVisitorsController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<?> visitorTable;

    @FXML
    private TableColumn<?, ?> colVisitorId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colEntryTime;

    @FXML
    private TableColumn<?, ?> colTicketType;

    @FXML
    private Button loadBtn;

    @FXML
    private void initialize() {
        System.out.println("MonitorVisitorsController initialized.");
        // TODO: Setup default table data if needed
    }

    @FXML
    private void handleLoadVisitors(ActionEvent event) {
        System.out.println("Load Visitors clicked for date: " + datePicker.getValue());
        // TODO: Load visitor data for selected date
    }
}
