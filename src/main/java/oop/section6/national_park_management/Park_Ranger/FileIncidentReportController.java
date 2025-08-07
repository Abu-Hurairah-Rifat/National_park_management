package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class FileIncidentReportController {

    @FXML private TextField typeField;
    @FXML private TextField locationField;
    @FXML private TextArea descriptionArea;
    @FXML private Button submitReportBtn;

    @FXML
    private void handleSubmitReport(ActionEvent event) {
        String type = typeField.getText();
        String location = locationField.getText();
        String description = descriptionArea.getText();

        if (type.isEmpty() || location.isEmpty() || description.isEmpty()) {
            System.out.println("All fields must be filled out.");
        } else {
            System.out.println("Incident Report Filed:\nType: " + type + "\nLocation: " + location + "\nDescription: " + description);
        }
    }
}
