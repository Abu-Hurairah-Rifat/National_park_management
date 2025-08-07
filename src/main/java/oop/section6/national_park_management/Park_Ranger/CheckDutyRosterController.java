package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class CheckDutyRosterController {

    @FXML private ComboBox<String> daySelector;
    @FXML private TextArea rosterDetailsArea;
    @FXML private Button viewBtn;

    @FXML
    private void initialize() {
        daySelector.getItems().addAll("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    }

    @FXML
    private void handleView(ActionEvent event) {
        String day = daySelector.getValue();
        if (day == null) {
            rosterDetailsArea.setText("Please select a day.");
        } else {
            // Dummy text; in a real app, data would come from a backend
            rosterDetailsArea.setText("Duty Roster for " + day + ":\n- 08:00 - 12:00: Ranger A\n- 12:00 - 16:00: Ranger B\n- 16:00 - 20:00: Ranger C");
        }
    }
}
