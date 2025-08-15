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

public class SubmitPatrolScheduleController {

    @FXML
    private DatePicker patrolDatePicker;

    @FXML
    private TableView<PatrolSchedule> patrolScheduleTable;

    @FXML
    private TableColumn<PatrolSchedule, String> colZone;

    @FXML
    private TableColumn<PatrolSchedule, String> colStartTime;

    @FXML
    private TableColumn<PatrolSchedule, String> colEndTime;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    private final ObservableList<PatrolSchedule> scheduleData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns to model properties
        colZone.setCellValueFactory(data -> data.getValue().zoneProperty());
        colStartTime.setCellValueFactory(data -> data.getValue().startTimeProperty());
        colEndTime.setCellValueFactory(data -> data.getValue().endTimeProperty());

        // Default patrol date to today
        patrolDatePicker.setValue(LocalDate.now());

        // Load mock data
        loadMockData();

        // Submit button handler
        submitButton.setOnAction(e -> submitSchedule());
    }

    private void loadMockData() {
        scheduleData.setAll(
                new PatrolSchedule("Zone A", "08:00 AM", "12:00 PM"),
                new PatrolSchedule("Zone B", "12:00 PM", "04:00 PM"),
                new PatrolSchedule("Zone C", "04:00 PM", "08:00 PM")
        );
        patrolScheduleTable.setItems(scheduleData);
    }

    private void submitSchedule() {
        LocalDate date = patrolDatePicker.getValue();
        if (date == null) {
            showAlert("Please select a date before submitting.");
            return;
        }

        // For now, just show confirmation (later connect to DB)
        showAlert("Patrol schedule for " + date + " submitted successfully!");
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
     * Inner model class for patrol schedule rows
     */
    public static class PatrolSchedule {
        private final javafx.beans.property.SimpleStringProperty zone;
        private final javafx.beans.property.SimpleStringProperty startTime;
        private final javafx.beans.property.SimpleStringProperty endTime;

        public PatrolSchedule(String zone, String startTime, String endTime) {
            this.zone = new javafx.beans.property.SimpleStringProperty(zone);
            this.startTime = new javafx.beans.property.SimpleStringProperty(startTime);
            this.endTime = new javafx.beans.property.SimpleStringProperty(endTime);
        }

        public javafx.beans.property.StringProperty zoneProperty() { return zone; }
        public javafx.beans.property.StringProperty startTimeProperty() { return startTime; }
        public javafx.beans.property.StringProperty endTimeProperty() { return endTime; }
    }
}
