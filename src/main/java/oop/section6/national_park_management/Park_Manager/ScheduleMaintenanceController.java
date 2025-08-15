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

import javax.swing.*;

public class ScheduleMaintenanceController {

    @FXML private Button backButton;
    @FXML private DatePicker datePicker;
    @FXML private TableView<MaintenanceTask> maintenanceTable;
    @FXML private TableColumn<MaintenanceTask, String> colTask;
    @FXML private TableColumn<MaintenanceTask, String> colLocation;
    @FXML private TableColumn<MaintenanceTask, String> colDate;
    @FXML private Button scheduleButton;

    protected ObservableList<MaintenanceTask> maintenanceList;

    @FXML
    public void initialize() {
        // Bind columns to model
        colTask.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("scheduledDate"));

        // Dummy data for preview
        maintenanceList = FXCollections.observableArrayList(
                new MaintenanceTask("Trail Clearing", "North Sector", "2025-08-20"),
                new MaintenanceTask("Fence Repair", "East Boundary", "2025-08-23"),
                new MaintenanceTask("Visitor Center Painting", "Main Gate", "2025-08-28")
        );

        maintenanceTable.setItems(maintenanceList);

        // Button actions
        scheduleButton.setOnAction(e -> scheduleTask());
        backButton.setOnAction(this::goBack);
    }

    private void scheduleTask() {
        MaintenanceTask selected = maintenanceTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            JOptionPane.showMessageDialog(null,
                    "Task '" + selected.getTaskName() + "' scheduled successfully.",
                    "Task Scheduled", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please select a task to schedule.",
                    "No Task Selected", JOptionPane.WARNING_MESSAGE);
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

    // Inner model class
    public static class MaintenanceTask {
        private String taskName;
        private String location;
        private String scheduledDate;

        public MaintenanceTask(String taskName, String location, String scheduledDate) {
            this.taskName = taskName;
            this.location = location;
            this.scheduledDate = scheduledDate;
        }

        public String getTaskName() { return taskName; }
        public String getLocation() { return location; }
        public String getScheduledDate() { return scheduledDate; }
    }
}
