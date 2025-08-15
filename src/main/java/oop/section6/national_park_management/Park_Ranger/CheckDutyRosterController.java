package oop.section6.national_park_management.Park_Ranger;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public class CheckDutyRosterController {

    @FXML
    private DatePicker rosterDatePicker;

    @FXML
    private TableView<RangerRoster> rosterTable;

    @FXML
    private TableColumn<RangerRoster, String> colRangerName;

    @FXML
    private TableColumn<RangerRoster, String> colShift;

    @FXML
    private TableColumn<RangerRoster, String> colZone;

    @FXML
    private Button backButton;

    @FXML
    private Button checkRosterButton;

    @FXML
    public void initialize() {
        // Link table columns to RangerRoster properties
        colRangerName.setCellValueFactory(data -> data.getValue().rangerNameProperty());
        colShift.setCellValueFactory(data -> data.getValue().shiftProperty());
        colZone.setCellValueFactory(data -> data.getValue().zoneProperty());

        // Optional: default date is today
        rosterDatePicker.setValue(LocalDate.now());

        // Handle Check Roster button click
        checkRosterButton.setOnAction(e -> loadRosterData());
    }

    /**
     * Load mock roster data (replace with DB query later)
     */
    private void loadRosterData() {
        LocalDate selectedDate = rosterDatePicker.getValue();
        if (selectedDate == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a date first.");
            alert.show();
            return;
        }

        // Mock data
        ObservableList<RangerRoster> data = FXCollections.observableArrayList(
                new RangerRoster("Steven Smith", "Morning", "Zone A"),
                new RangerRoster("Jouse Brown", "Afternoon", "Zone B"),
                new RangerRoster("David Bk", "Night", "Zone C")
        );

        rosterTable.setItems(data);
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

    /**
     * Model class for table rows
     */
    public static class RangerRoster {
        private final SimpleStringProperty rangerName;
        private final SimpleStringProperty shift;
        private final SimpleStringProperty zone;

        public RangerRoster(String rangerName, String shift, String zone) {
            this.rangerName = new SimpleStringProperty(rangerName);
            this.shift = new SimpleStringProperty(shift);
            this.zone = new SimpleStringProperty(zone);
        }

        public StringProperty rangerNameProperty() { return rangerName; }
        public StringProperty shiftProperty() { return shift; }
        public StringProperty zoneProperty() { return zone; }
    }
}
