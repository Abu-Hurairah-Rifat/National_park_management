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

public class ApproveScheduleController {

    @FXML private Button backButton;
    @FXML private DatePicker datePicker;
    @FXML private TableView<Schedule> scheduleTable;
    @FXML private TableColumn<Schedule, String> colRanger;
    @FXML private TableColumn<Schedule, String> colDate;
    @FXML private TableColumn<Schedule, String> colStatus;
    @FXML private Button approveButton;

    private ObservableList<Schedule> scheduleList;

    @FXML
    public void initialize() {
        // Configure table columns
        colRanger.setCellValueFactory(new PropertyValueFactory<>("rangerName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Dummy data
        scheduleList = FXCollections.observableArrayList(
                new Schedule("Jamal Khan", "2025-07-15", "Pending"),
                new Schedule("Steven Smith", "2025-06-16", "Pending"),
                new Schedule("Ali Khan", "2025-05-17", "Approved")
        );

        scheduleTable.setItems(scheduleList);

        // Approve Button Action
        approveButton.setOnAction(e -> approveSelectedSchedule());

        // Back Button Action
        backButton.setOnAction(e -> goBack(e));
    }

    private void approveSelectedSchedule() {
        Schedule selected = scheduleTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Approved");
            scheduleTable.refresh();
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
    public static class Schedule {
        private final String rangerName;
        private final String date;
        private String status;

        public Schedule(String rangerName, String date, String status) {
            this.rangerName = rangerName;
            this.date = date;
            this.status = status;
        }

        public String getRangerName() { return rangerName; }
        public String getDate() { return date; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
