package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ViewPatrolZoneMapController {

    @FXML private ComboBox<String> zoneSelector;
    @FXML private TextArea zoneDetailsArea;
    @FXML private Button loadMapBtn;

    @FXML
    private void initialize() {
        zoneSelector.getItems().addAll("Zone A", "Zone B", "Zone C", "Zone D");
    }

    @FXML
    private void handleLoadMap(ActionEvent event) {
        String zone = zoneSelector.getValue();
        if (zone == null) {
            zoneDetailsArea.setText("Please select a zone to view details.");
        } else {
            // In a real app, fetch details from database
            zoneDetailsArea.setText("Details for " + zone + ":\n- Area: 12 sq km\n- Assigned Rangers: 3\n- Wildlife Type: Deer, Fox");
        }
    }
}
