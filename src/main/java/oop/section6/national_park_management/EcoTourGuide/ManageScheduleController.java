package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManageScheduleController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button blockDatesButton;
    @FXML
    private DatePicker blockEndDatePicker;
    @FXML
    private DatePicker blockStartDatePicker;
    @FXML
    private Button saveHoursButton;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField workHoursEndField;
    @FXML
    private TextField workHoursStartField;

    @FXML
    void initialize() {
        saveHoursButton.setOnAction(this::handleSaveWeeklyHours);
        blockDatesButton.setOnAction(this::handleBlockDates);
    }

    private void handleSaveWeeklyHours(ActionEvent event) {
        String startTime = workHoursStartField.getText();
        String endTime = workHoursEndField.getText();

        if (startTime == null || startTime.trim().isEmpty() || endTime == null || endTime.trim().isEmpty()) {
            showAlert("Input Error", "Please enter both a start and end time for your weekly hours.");
            return;
        }

        System.out.println("Saving recurring weekly hours: " + startTime + " - " + endTime);
        statusLabel.setText("Weekly hours have been updated.");
        statusLabel.setStyle("-fx-text-fill: green;");
    }

    private void handleBlockDates(ActionEvent event) {
        LocalDate startDate = blockStartDatePicker.getValue();
        LocalDate endDate = blockEndDatePicker.getValue();

        if (startDate == null || endDate == null) {
            showAlert("Input Error", "Please select both a start and end date to block.");
            return;
        }

        if (endDate.isBefore(startDate)) {
            showAlert("Input Error", "The selected end date cannot be before the start date.");
            return;
        }

        System.out.println("Blocking dates as unavailable from " + startDate + " to " + endDate);
        statusLabel.setText("Dates from " + startDate + " to " + endDate + " are now blocked.");
        statusLabel.setStyle("-fx-text-fill: green;");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}