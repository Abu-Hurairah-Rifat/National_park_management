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

public class ReportVisitorMisconductController {

    @FXML
    private DatePicker incidentDatePicker;

    @FXML
    private TableView<VisitorMisconduct> misconductTable;

    @FXML
    private TableColumn<VisitorMisconduct, String> colVisitorName;

    @FXML
    private TableColumn<VisitorMisconduct, String> colIncident;

    @FXML
    private TableColumn<VisitorMisconduct, String> colActionTaken;

    @FXML
    private Button backButton;

    @FXML
    private Button reportMisconductButton;

    private final ObservableList<VisitorMisconduct> misconductData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Link table columns to model properties
        colVisitorName.setCellValueFactory(data -> data.getValue().visitorNameProperty());
        colIncident.setCellValueFactory(data -> data.getValue().incidentProperty());
        colActionTaken.setCellValueFactory(data -> data.getValue().actionTakenProperty());

        // Default date to today
        incidentDatePicker.setValue(LocalDate.now());

        // Load some mock data
        loadMockData();

        // Handle Report Misconduct button
        reportMisconductButton.setOnAction(e -> addNewMisconductReport());
    }

    private void loadMockData() {
        misconductData.setAll(
                new VisitorMisconduct("John Doe", "Littering", "Issued fine"),
                new VisitorMisconduct("Jane Smith", "Off-trail hiking", "Verbal warning"),
                new VisitorMisconduct("Mark Brown", "Feeding oop.section6.national_park_management.wildlife", "Expelled from park")
        );
        misconductTable.setItems(misconductData);
    }

    private void addNewMisconductReport() {
        LocalDate date = incidentDatePicker.getValue();
        if (date == null) {
            showAlert("Please select an incident date first.");
            return;
        }

        // Adding placeholder/mock data — replace with real input fields later
        misconductData.add(new VisitorMisconduct("New Visitor", "New Incident", "Pending Review"));
        showAlert("Visitor misconduct report filed successfully!");
    }

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
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Inner model class for misconduct table rows
     */
    public static class VisitorMisconduct {
        private final javafx.beans.property.SimpleStringProperty visitorName;
        private final javafx.beans.property.SimpleStringProperty incident;
        private final javafx.beans.property.SimpleStringProperty actionTaken;

        public VisitorMisconduct(String visitorName, String incident, String actionTaken) {
            this.visitorName = new javafx.beans.property.SimpleStringProperty(visitorName);
            this.incident = new javafx.beans.property.SimpleStringProperty(incident);
            this.actionTaken = new javafx.beans.property.SimpleStringProperty(actionTaken);
        }

        public javafx.beans.property.StringProperty visitorNameProperty() { return visitorName; }
        public javafx.beans.property.StringProperty incidentProperty() { return incident; }
        public javafx.beans.property.StringProperty actionTakenProperty() { return actionTaken; }
    }
}
