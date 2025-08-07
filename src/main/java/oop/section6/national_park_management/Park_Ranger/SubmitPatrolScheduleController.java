package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class SubmitPatrolScheduleController {

    @FXML private TextField zoneField;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> timeSlotComboBox;
    @FXML private Button submitBtn;

    @FXML
    private void initialize() {
        timeSlotComboBox.getItems().addAll("Morning", "Afternoon", "Evening", "Night");
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        String zone = zoneField.getText();
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : null;
        String slot = timeSlotComboBox.getValue();

        if (zone.isEmpty() || date == null || slot == null) {
            System.out.println("Please fill all fields.");
        } else {
            System.out.println("Schedule Submitted: " + zone + " | " + date + " | " + slot);
        }
    }
}
