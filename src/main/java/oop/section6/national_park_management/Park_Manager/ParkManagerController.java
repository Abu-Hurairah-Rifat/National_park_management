package oop.section6.national_park_management.Park_Manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ParkManagerController {

    // ================= GOAL 1 =================
    @FXML
    private void openApproveSchedules(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/ApproveScheduleView.fxml");
    }

    // ================= GOAL 2 =================
    @FXML
    private void openMonitorVisitors(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/MonitorVisitorsView.fxml");
    }

    // ================= GOAL 3 =================
    @FXML
    private void openReviewIncidentReports(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/ReviewIncidentReportsView.fxml");
    }

    // ================= GOAL 4 =================
    @FXML
    private void openAssignPatrolZones(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/AssignPatrolZonesView.fxml");
    }

    // ================= GOAL 5 =================
    @FXML
    private void openManageWildlifeCensus(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/ManageWildlifeCensusView.fxml");
    }

    // ================= GOAL 6 =================
    @FXML
    private void openScheduleMaintenance(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/ScheduleMaintenanceView.fxml");
    }

    // ================= GOAL 7 =================
    @FXML
    private void openSetEntryFeeRates(ActionEvent event) {
        switchScene(event, "/oop/section6/national_park_management/Park_Manager/SetEntryFeeRatesView.fxml");
    }

    // ================= GOAL 8 =================
    @FXML
    private void openExportFinance(ActionEvent event) {

        switchScene(event, "/oop/section6/national_park_management/Park_Manager/ExportFinancialReportsView.fxml");
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
