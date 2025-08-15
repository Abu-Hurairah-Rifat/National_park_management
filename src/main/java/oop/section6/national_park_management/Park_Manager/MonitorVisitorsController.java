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

public class MonitorVisitorsController {

    @FXML private Button backButton;
    @FXML private DatePicker datePicker;
    @FXML private TableView<VisitorRecord> visitorTable;
    @FXML private TableColumn<VisitorRecord, String> colName;
    @FXML private TableColumn<VisitorRecord, String> colEntry;
    @FXML private TableColumn<VisitorRecord, String> colExit;
    @FXML private Button refreshButton;

    private ObservableList<VisitorRecord> visitorList;

    @FXML
    public void initialize() {
        // Link table columns to model fields
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEntry.setCellValueFactory(new PropertyValueFactory<>("entryTime"));
        colExit.setCellValueFactory(new PropertyValueFactory<>("exitTime"));

        // Dummy data
        visitorList = FXCollections.observableArrayList(
                new VisitorRecord("John Smith", "09:15 AM", "12:30 PM"),
                new VisitorRecord("Maria Lopez", "10:00 AM", "02:45 PM"),
                new VisitorRecord("Arif Hossain", "11:20 AM", "04:10 PM")
        );

        visitorTable.setItems(visitorList);

        // Button actions
        refreshButton.setOnAction(e -> refreshData());
        backButton.setOnAction(this::goBack);
    }

    private void refreshData() {
        System.out.println("Refreshing data for date: " + datePicker.getValue());
        // In real app, load from DB or API
        visitorTable.setItems(visitorList);
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
    public static class VisitorRecord {
        private String name;
        private String entryTime;
        private String exitTime;

        public VisitorRecord(String name, String entryTime, String exitTime) {
            this.name = name;
            this.entryTime = entryTime;
            this.exitTime = exitTime;
        }

        public String getName() { return name; }
        public String getEntryTime() { return entryTime; }
        public String getExitTime() { return exitTime; }
    }
}
