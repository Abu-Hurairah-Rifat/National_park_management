package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ReportVisitorMisconductController {

    @FXML private TextField visitorNameField;
    @FXML private TextField incidentLocationField;
    @FXML private TextArea misconductDescriptionArea;
    @FXML private Button submitMisconductBtn;

    @FXML
    private void handleSubmitMisconduct(ActionEvent event) {
        String visitorName = visitorNameField.getText();
        String location = incidentLocationField.getText();
        String description = misconductDescriptionArea.getText();

        if (visitorName.isEmpty() || location.isEmpty() || description.isEmpty()) {
            System.out.println("All fields are required.");
        } else {
            System.out.println("Misconduct Reported:\nVisitor: " + visitorName + "\nLocation: " + location + "\nDetails: " + description);
        }
    }
}
