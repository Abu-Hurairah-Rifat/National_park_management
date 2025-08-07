package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class AssignPatrolZonesController {

    @FXML
    private ComboBox<String> rangerComboBox;

    @FXML
    private TableView<?> zoneTable;

    @FXML
    private TableColumn<?, ?> colZoneId;

    @FXML
    private TableColumn<?, ?> colZoneName;

    @FXML
    private TableColumn<?, ?> colBoundaries;

    @FXML
    private Button assignBtn;

    @FXML
    private void initialize() {
        System.out.println("AssignPatrolZonesController initialized.");
        // TODO: Populate rangerComboBox and zoneTable with data
    }

    @FXML
    private void handleAssignZone(ActionEvent event) {
        System.out.println("Assign button clicked.");
        // TODO: Assign selected zone to selected ranger
    }
}
