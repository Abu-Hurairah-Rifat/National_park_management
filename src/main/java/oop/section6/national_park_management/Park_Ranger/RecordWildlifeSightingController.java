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

public class RecordWildlifeSightingController {

    @FXML
    private DatePicker sightingDatePicker;

    @FXML
    private TableView<WildlifeSighting> sightingTable;

    @FXML
    private TableColumn<WildlifeSighting, String> colSpecies;

    @FXML
    private TableColumn<WildlifeSighting, String> colLocation;

    @FXML
    private TableColumn<WildlifeSighting, String> colNotes;

    @FXML
    private Button backButton;

    @FXML
    private Button recordButton;

    private ObservableList<WildlifeSighting> sightings = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns
        colSpecies.setCellValueFactory(data -> data.getValue().speciesProperty());
        colLocation.setCellValueFactory(data -> data.getValue().locationProperty());
        colNotes.setCellValueFactory(data -> data.getValue().notesProperty());

        // Default date
        sightingDatePicker.setValue(LocalDate.now());

        // Load mock sightings
        loadMockSightings();

        // Handle record button
        recordButton.setOnAction(e -> recordNewSighting());
    }

    /**
     * Load some example data
     */
    private void loadMockSightings() {
        sightings.setAll(
                new WildlifeSighting("Elephant", "Zone A", "Near waterhole"),
                new WildlifeSighting("Lion", "Zone B", "Resting under tree"),
                new WildlifeSighting("Giraffe", "Zone C", "Feeding on acacia leaves")
        );
        sightingTable.setItems(sightings);
    }

    /**
     * Add a test record (replace with form fields later)
     */
    private void recordNewSighting() {
        LocalDate date = sightingDatePicker.getValue();
        if (date == null) {
            showAlert("Please select a date first.");
            return;
        }

        sightings.add(new WildlifeSighting("New Species", "New Location", "No notes"));
        showAlert("Wildlife sighting recorded successfully!");
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
     * Utility to show alerts
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
    public static class WildlifeSighting {
        private final javafx.beans.property.SimpleStringProperty species;
        private final javafx.beans.property.SimpleStringProperty location;
        private final javafx.beans.property.SimpleStringProperty notes;

        public WildlifeSighting(String species, String location, String notes) {
            this.species = new javafx.beans.property.SimpleStringProperty(species);
            this.location = new javafx.beans.property.SimpleStringProperty(location);
            this.notes = new javafx.beans.property.SimpleStringProperty(notes);
        }

        public javafx.beans.property.StringProperty speciesProperty() { return species; }
        public javafx.beans.property.StringProperty locationProperty() { return location; }
        public javafx.beans.property.StringProperty notesProperty() { return notes; }
    }
}
