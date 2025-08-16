package oop.section6.national_park_management.Park_Ranger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ParkRangerController {

    // ================= GOAL 1 =================
    @FXML
    private void openSubmitPatrolSchedule(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/SubmitPatrolScheduleView.fxml");
    }

    // ================= GOAL 2 =================
    @FXML
    private void openRecordWildlifeSighting(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/RecordWildlifeSightingView.fxml");
    }

    // ================= GOAL 3 =================
    @FXML
    private void openFileIncidentReport(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/FileIncidentReportView.fxml");
    }

    // ================= GOAL 4 =================
    @FXML
    private void openViewPatrolZoneMap(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/ViewPatrolZoneMapView.fxml");
    }

    // ================= GOAL 5 =================
    @FXML
    private void openLogMaintenanceNeeds(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/LogMaintenanceNeedsView.fxml");
    }

    // ================= GOAL 6 =================
    @FXML
    private void openCheckDutyRoster(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/CheckDutyRosterView.fxml");
    }

    // ================= GOAL 7 =================
    @FXML
    private void openReportVisitorMisconduct(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/ReportVisitorMisconductView.fxml");
    }

    // ================= GOAL 8 =================
    @FXML
    private void openUpdateProfile(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park Ranger/UpdateProfileView.fxml");
    }

    // ================= LOGOUT =================
    @FXML
    private void logout(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/log-in-view.fxml");
    }

    // ================= HELPER METHOD =================
    private void switchScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("❌ ERROR: Could not load " + fxmlPath);
            e.printStackTrace();
        }
    }
}
