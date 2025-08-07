package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class LogMaintenanceNeedsController {

    @FXML private TextField issueTypeField;
    @FXML private TextField locationField;
    @FXML private TextArea descriptionArea;
    @FXML private Button submitBtn;

    @FXML
    private void handleSubmit(ActionEvent event) {
        String type = issueTypeField.getText();
        String location = locationField.getText();
        String description = descriptionArea.getText();

        if (type.isEmpty() || location.isEmpty() || description.isEmpty()) {
            System.out.println("Please complete all fields.");
        } else {
            System.out.println("Maintenance Issue Logged:\nType: " + type + "\nLocation: " + location + "\nDescription: " + description);
        }
    }
}
