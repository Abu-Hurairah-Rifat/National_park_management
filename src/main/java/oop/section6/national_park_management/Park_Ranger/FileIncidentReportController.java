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

public class FileIncidentReportController {

    @FXML
    private DatePicker incidentDatePicker;

    @FXML
    private TableView<IncidentReport> incidentTable;

    @FXML
    private TableColumn<IncidentReport, String> colIncidentType;

    @FXML
    private TableColumn<IncidentReport, String> colLocation;

    @FXML
    private TableColumn<IncidentReport, String> colDescription;

    @FXML
    private Button backButton;

    @FXML
    private Button fileReportButton;

    // Data for the table
    private ObservableList<IncidentReport> incidentData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns to properties
        colIncidentType.setCellValueFactory(data -> data.getValue().incidentTypeProperty());
        colLocation.setCellValueFactory(data -> data.getValue().locationProperty());
        colDescription.setCellValueFactory(data -> data.getValue().descriptionProperty());

        // Set today's date by default
        incidentDatePicker.setValue(LocalDate.now());

        // Load mock data
        loadMockIncidents();

        // File Report button action
        fileReportButton.setOnAction(e -> fileNewReport());

        // Back button action
        backButton.setOnAction(this::goBack);
    }

    /**
     * Load mock incident data into the table
     */
    private void loadMockIncidents() {
        incidentData.setAll(
                new IncidentReport("Poaching", "Zone A", "Suspicious hunting activity"),
                new IncidentReport("Lost Visitor", "Zone B", "Visitor reported missing for 2 hours"),
                new IncidentReport("Wildlife Injury", "Zone C", "Injured deer spotted")
        );
        incidentTable.setItems(incidentData);
    }

    /**
     * Adds a mock new report (replace with form inputs in the future)
     */
    private void fileNewReport() {
        LocalDate date = incidentDatePicker.getValue();
        if (date == null) {
            showAlert("Please select a date for the incident.");
            return;
        }

        // Here we just add a dummy entry for testing
        incidentData.add(new IncidentReport("New Type", "New Location", "New Description"));
        showAlert("Incident report filed successfully!");
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
     * Utility method to show alerts
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
    public static class IncidentReport {
        private final javafx.beans.property.SimpleStringProperty incidentType;
        private final javafx.beans.property.SimpleStringProperty location;
        private final javafx.beans.property.SimpleStringProperty description;

        public IncidentReport(String incidentType, String location, String description) {
            this.incidentType = new javafx.beans.property.SimpleStringProperty(incidentType);
            this.location = new javafx.beans.property.SimpleStringProperty(location);
            this.description = new javafx.beans.property.SimpleStringProperty(description);
        }

        public javafx.beans.property.StringProperty incidentTypeProperty() { return incidentType; }
        public javafx.beans.property.StringProperty locationProperty() { return location; }
        public javafx.beans.property.StringProperty descriptionProperty() { return description; }
    }
}
