package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class RecordWildlifeSightingController {

    @FXML private TextField speciesField;
    @FXML private TextField locationField;
    @FXML private TextArea notesArea;
    @FXML private Button recordBtn;

    @FXML
    private void handleRecord(ActionEvent event) {
        String species = speciesField.getText();
        String location = locationField.getText();
        String notes = notesArea.getText();

        if (species.isEmpty() || location.isEmpty()) {
            System.out.println("Species and location must be filled.");
        } else {
            System.out.println("Sighting recorded: " + species + " at " + location + " | Notes: " + notes);
        }
    }
}
