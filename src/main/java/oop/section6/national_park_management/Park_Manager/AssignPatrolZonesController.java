package oop.section6.national_park_management.Park_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AssignPatrolZonesController {

    @FXML private Button backButton;
    @FXML private DatePicker datePicker;
    @FXML private TableView<PatrolZone> zoneTable;
    @FXML private TableColumn<PatrolZone, String> colRanger;
    @FXML private TableColumn<PatrolZone, String> colZone;
    @FXML private TableColumn<PatrolZone, String> colDate;
    @FXML private Button assignButton;

    private ObservableList<PatrolZone> patrolZoneList;

    @FXML
    public void initialize() {
        // Set up table columns
        colRanger.setCellValueFactory(new PropertyValueFactory<>("rangerName"));
        colZone.setCellValueFactory(new PropertyValueFactory<>("assignedZone"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("dateAssigned"));

        // Dummy data
        patrolZoneList = FXCollections.observableArrayList(
                new PatrolZone("Jony Khan", "North Sector", "2025-08-10"),
                new PatrolZone("Steven Smith", "East Sector", "2025-08-11"),
                new PatrolZone("Ali Khan", "Unassigned", "")
        );

        zoneTable.setItems(patrolZoneList);

        // Assign Zone Action
        assignButton.setOnAction(e -> assignZone());

        // Back Button Action
        backButton.setOnAction(e -> goBack(e));
    }

    private void assignZone() {
        PatrolZone selected = zoneTable.getSelectionModel().getSelectedItem();
        if (selected != null && datePicker.getValue() != null) {
            selected.setAssignedZone("New Zone"); // For demo, we set a placeholder zone
            selected.setDateAssigned(datePicker.getValue().toString());
            zoneTable.refresh();
        }
    }

    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/oop/section6/national_park_management/Park_Manager/ParkManagerDashboard.fxml"
            ));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Park Manager Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inner Model Class
    public static class PatrolZone {
        private final String rangerName;
        private String assignedZone;
        private String dateAssigned;

        public PatrolZone(String rangerName, String assignedZone, String dateAssigned) {
            this.rangerName = rangerName;
            this.assignedZone = assignedZone;
            this.dateAssigned = dateAssigned;
        }

        public String getRangerName() { return rangerName; }
        public String getAssignedZone() { return assignedZone; }
        public String getDateAssigned() { return dateAssigned; }

        public void setAssignedZone(String assignedZone) { this.assignedZone = assignedZone; }
        public void setDateAssigned(String dateAssigned) { this.dateAssigned = dateAssigned; }
    }
}
