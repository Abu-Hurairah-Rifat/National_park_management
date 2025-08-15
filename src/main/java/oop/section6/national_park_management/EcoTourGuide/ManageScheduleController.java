package oop.section6.national_park_management.EcoTourGuide;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.net.URL;

public class ManageScheduleController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private GridPane calendarGridPane;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button saveHoursButton;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Label statusLabel;
    @FXML
    private ComboBox<ScheduleModel.DayStatus> statusComboBox;
    @FXML
    private Button updateStatusButton;
    @FXML
    private TextField workHoursEndField;
    @FXML
    private TextField workHoursStartField;

    private final ScheduleModel scheduleModel = new ScheduleModel();
    private final YearMonth currentMonth = YearMonth.now();
    // These maps now store references to the VBox cell and the hours Label
    private final Map<LocalDate, VBox> dateCells = new HashMap<>();
    private final Map<LocalDate, Label> weeklyHoursLabels = new HashMap<>();

    @FXML
    void initialize() {
        populateCalendar();

        statusComboBox.setItems(FXCollections.observableArrayList(ScheduleModel.DayStatus.values()));

        saveHoursButton.setOnAction(this::handleSaveWeeklyHours);
        updateStatusButton.setOnAction(this::handleUpdateStatus);
    }

    private void populateCalendar() {
        calendarGridPane.getChildren().clear();
        dateCells.clear();
        weeklyHoursLabels.clear();

        Label monthLabel = new Label(currentMonth.getMonth().toString() + " " + currentMonth.getYear());
        monthLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
        calendarGridPane.add(monthLabel, 0, 0, 7, 1);
        GridPane.setHalignment(monthLabel, HPos.CENTER);

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < daysOfWeek.length; i++) {
            Label dayLabel = new Label(daysOfWeek[i]);
            calendarGridPane.add(dayLabel, i, 1);
            GridPane.setHalignment(dayLabel, HPos.CENTER);
        }

        LocalDate firstOfMonth = currentMonth.atDay(1);
        int dayOfWeekOfFirst = firstOfMonth.getDayOfWeek().getValue() % 7;

        for (int day = 1; day <= currentMonth.lengthOfMonth(); day++) {
            LocalDate date = currentMonth.atDay(day);

            Label dayLabel = new Label(String.valueOf(day));
            Label hoursLabel = new Label();
            hoursLabel.setFont(Font.font("System", FontWeight.BOLD, 10));

            VBox dayCell = new VBox(5, dayLabel, hoursLabel);
            dayCell.setAlignment(Pos.CENTER);
            dayCell.setPrefSize(60, 50);

            int row = (day + dayOfWeekOfFirst - 1) / 7 + 2;
            int col = (day + dayOfWeekOfFirst - 1) % 7;

            calendarGridPane.add(dayCell, col, row);
            dateCells.put(date, dayCell);
            weeklyHoursLabels.put(date, hoursLabel);
        }

        updateCalendarStyles();
    }

    private void updateCalendarStyles() {
        dateCells.forEach((date, cell) -> {
            ScheduleModel.DayStatus status = scheduleModel.getStatusForDate(date);
            String style = switch (status) {
                case AVAILABLE -> "-fx-background-color: #c8e6c9;";
                case BOOKED -> "-fx-background-color: #bbdefb;";
                case BLOCKED -> "-fx-background-color: #ffcdd2;";
            };
            cell.setStyle(style);
        });
    }

    private void updateWeeklyHoursDisplay() {
        String startTime = scheduleModel.getWeeklyStartTime();
        String endTime = scheduleModel.getWeeklyEndTime();

        if (startTime == null || endTime == null) {
            return;
        }

        String hoursText = startTime + " - " + endTime;

        weeklyHoursLabels.forEach((date, label) -> {
            DayOfWeek day = date.getDayOfWeek();
            // Assuming a standard Monday-Friday work week
            if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
                label.setText(hoursText);
            } else {
                label.setText("");
            }
        });
    }

    private void handleSaveWeeklyHours(ActionEvent event) {
        String startTime = workHoursStartField.getText();
        String endTime = workHoursEndField.getText();

        if (startTime.trim().isEmpty() || endTime.trim().isEmpty()) {
            showAlert("Input Error", "Please enter both a start and end time.");
            return;
        }

        scheduleModel.setWeeklyHours(startTime, endTime);
        updateWeeklyHoursDisplay(); // This line updates the calendar view

        statusLabel.setText("Weekly hours updated.");
        statusLabel.setStyle("-fx-text-fill: green;");
    }

    private void handleUpdateStatus(ActionEvent event) {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        ScheduleModel.DayStatus status = statusComboBox.getValue();

        if (startDate == null || endDate == null || status == null) {
            showAlert("Input Error", "Please select a start date, end date, and status.");
            return;
        }

        if (endDate.isBefore(startDate)) {
            showAlert("Input Error", "The end date cannot be before the start date.");
            return;
        }

        scheduleModel.setDateStatus(startDate, endDate, status);
        updateCalendarStyles();

        statusLabel.setText("Schedule updated for the selected dates.");
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