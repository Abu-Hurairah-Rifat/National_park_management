package oop.section6.national_park_management.Park_Ranger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class LogMaintenanceNeedsController {

    @FXML
    private DatePicker maintenanceDatePicker;

    @FXML
    private TableView<MaintenanceRecord> maintenanceTable;

    @FXML
    private TableColumn<MaintenanceRecord, String> colArea;

    @FXML
    private TableColumn<MaintenanceRecord, String> colIssue;

    @FXML
    private TableColumn<MaintenanceRecord, String> colPriority;

    @FXML
    private Button backButton;

    @FXML
    private Button logMaintenanceButton;

    private ObservableList<MaintenanceRecord> maintenanceData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns to properties
        colArea.setCellValueFactory(data -> data.getValue().areaProperty());
        colIssue.setCellValueFactory(data -> data.getValue().issueProperty());
        colPriority.setCellValueFactory(data -> data.getValue().priorityProperty());

        // Default date to today
        maintenanceDatePicker.setValue(LocalDate.now());

        // Load sample data
        loadMockMaintenance();

        // Handle log button
        logMaintenanceButton.setOnAction(e -> logNewMaintenance());
    }

    /**
     * Loads sample maintenance needs
     */
    private void loadMockMaintenance() {
        maintenanceData.setAll(
                new MaintenanceRecord("Zone A", "Broken fence", "High"),
                new MaintenanceRecord("Visitor Center", "Leaky roof", "Medium"),
                new MaintenanceRecord("Trail 3", "Fallen tree blocking path", "High")
        );
        maintenanceTable.setItems(maintenanceData);
    }

    /**
     * Add a mock new maintenance record
     */
    private void logNewMaintenance() {
        LocalDate date = maintenanceDatePicker.getValue();
        if (date == null) {
            showAlert("Please select a maintenance date.");
            return;
        }

        // Dummy record for testing
        maintenanceData.add(new MaintenanceRecord("New Area", "New Issue", "Low"));
        showAlert("Maintenance need logged successfully!");
    }

    /**
     * Go back to Park Ranger Dashboard
     */
    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/oop/section6/national_park_management/Park Ranger/ParkRangerDashboard.fxml"
            ));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Park Ranger Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Utility alert
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Model class for table rows
     */
    public static class MaintenanceRecord {
        private final javafx.beans.property.SimpleStringProperty area;
        private final javafx.beans.property.SimpleStringProperty issue;
        private final javafx.beans.property.SimpleStringProperty priority;

        public MaintenanceRecord(String area, String issue, String priority) {
            this.area = new javafx.beans.property.SimpleStringProperty(area);
            this.issue = new javafx.beans.property.SimpleStringProperty(issue);
            this.priority = new javafx.beans.property.SimpleStringProperty(priority);
        }

        public javafx.beans.property.StringProperty areaProperty() { return area; }
        public javafx.beans.property.StringProperty issueProperty() { return issue; }
        public javafx.beans.property.StringProperty priorityProperty() { return priority; }
    }
}
