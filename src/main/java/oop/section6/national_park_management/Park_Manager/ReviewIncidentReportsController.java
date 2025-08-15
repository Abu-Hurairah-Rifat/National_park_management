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

import static javax.swing.JOptionPane.*;

public class ReviewIncidentReportsController {

    @FXML private Button backButton;
    @FXML private DatePicker datePicker;
    @FXML private TableView<IncidentRecord> incidentTable;
    @FXML private TableColumn<IncidentRecord, String> colID;
    @FXML private TableColumn<IncidentRecord, String> colType;
    @FXML private TableColumn<IncidentRecord, String> colDate;
    @FXML private Button viewButton;

    protected ObservableList<IncidentRecord> incidentList;

    @FXML
    public void initialize() {
        // Link table columns to model fields
        colID.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Dummy data for testing
        incidentList = FXCollections.observableArrayList(
                new IncidentRecord("R001", "Wildlife Injury", "2025-08-01"),
                new IncidentRecord("R002", "Visitor Misconduct", "2025-08-05"),
                new IncidentRecord("R003", "Illegal Logging", "2025-08-10")
        );

        incidentTable.setItems(incidentList);

        // Button actions
        viewButton.setOnAction(e -> viewDetails());
        backButton.setOnAction(this::goBack);
    }

    private void viewDetails() {
        IncidentRecord selected = incidentTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            showMessageDialog(null,
                    "Report ID: " + selected.getReportId() +
                            "\nType: " + selected.getIncidentType() +
                            "\nDate: " + selected.getDate(),
                    "Incident Details", INFORMATION_MESSAGE);
        } else {
            showMessageDialog(null,
                    "Please select a report first.",
                    "No Selection", WARNING_MESSAGE);
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
    // Inner model class for incidents
    public static class IncidentRecord {
        private String reportId;
        private String incidentType;
        private String date;

        public IncidentRecord(String reportId, String incidentType, String date) {
            this.reportId = reportId;
            this.incidentType = incidentType;
            this.date = date;
        }

        public String getReportId() { return reportId; }
        public String getIncidentType() { return incidentType; }
        public String getDate() { return date; }
    }
}
