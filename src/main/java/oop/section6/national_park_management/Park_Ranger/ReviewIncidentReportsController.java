package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ReviewIncidentReportsController {

    @FXML
    private TableView<?> incidentTable;

    @FXML
    private TableColumn<?, ?> colIncidentId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private Button markReviewedBtn;

    @FXML
    private Button assignTeamBtn;

    @FXML
    private Button refreshBtn;

    @FXML
    private void initialize() {
        System.out.println("ReviewIncidentReportsController initialized.");
        // TODO: Load incident reports into table
    }

    @FXML
    private void handleMarkReviewed(ActionEvent event) {
        System.out.println("Marked selected incident as reviewed.");
        // TODO: Update incident status
    }

    @FXML
    private void handleAssignTeam(ActionEvent event) {
        System.out.println("Assigned incident to team.");
        // TODO: Assign to response team
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        System.out.println("Refreshed incident report list.");
        // TODO: Refresh table data
    }
}
