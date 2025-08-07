package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

public class ParkRangerController {

    public GridPane buttonGrid;
    @FXML
    private Button logoutButton;
    @FXML
    private Button submitScheduleBtn;
    @FXML
    private Button recordSightingBtn;
    @FXML
    private Button fileIncidentBtn;
    @FXML
    private Button viewZoneMapBtn;
    @FXML
    private Button logMaintenanceBtn;
    @FXML
    private Button dutyRosterBtn;
    @FXML
    private Button reportMisconductBtn;
    @FXML
    private Button updateProfileBtn;

    @FXML
    private void initialize() {
        // Optional: initialize logic here
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        System.out.println("Logout clicked - handle scene change here.");
        // Add logout logic
    }

    @FXML
    private void handleSubmitSchedule(ActionEvent event) {
        System.out.println("Submit Patrol Schedule clicked.");
        // Load SubmitPatrolScheduleView.fxml
    }

    @FXML
    private void handleRecordSighting(ActionEvent event) {
        System.out.println("Record Wildlife Sighting clicked.");
        // Load RecordWildlifeSightingView.fxml
    }

    @FXML
    private void handleFileIncident(ActionEvent event) {
        System.out.println("File Incident Report clicked.");
        // Load FileIncidentReportView.fxml
    }

    @FXML
    private void handleViewZoneMap(ActionEvent event) {
        System.out.println("View Patrol Zone Map clicked.");
        // Load ViewPatrolZoneMapView.fxml
    }

    @FXML
    private void handleLogMaintenance(ActionEvent event) {
        System.out.println("Log Maintenance Needs clicked.");
        // Load LogMaintenanceNeedsView.fxml
    }

    @FXML
    private void handleDutyRoster(ActionEvent event) {
        System.out.println("Check Duty Roster clicked.");
        // Load CheckDutyRosterView.fxml
    }

    @FXML
    private void handleReportMisconduct(ActionEvent event) {
        System.out.println("Report Visitor Misconduct clicked.");
        // Load ReportVisitorMisconductView.fxml
    }

    @FXML
    private void handleUpdateProfile(ActionEvent event) {
        System.out.println("Update Profile clicked.");
        // Load UpdateProfileView.fxml
    }
}
