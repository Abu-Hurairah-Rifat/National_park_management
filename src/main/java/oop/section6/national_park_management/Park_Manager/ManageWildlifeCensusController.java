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

public class ManageWildlifeCensusController {

    @FXML private Button backButton;
    @FXML private DatePicker datePicker;
    @FXML private TableView<CensusRecord> censusTable;
    @FXML private TableColumn<CensusRecord, String> colSpecies;
    @FXML private TableColumn<CensusRecord, Integer> colCount;
    @FXML private TableColumn<CensusRecord, String> colDate;
    @FXML private Button updateButton;

    private ObservableList<CensusRecord> censusList;

    @FXML
    public void initialize() {
        // Link columns to model properties
        colSpecies.setCellValueFactory(new PropertyValueFactory<>("species"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Dummy data
        censusList = FXCollections.observableArrayList(
                new CensusRecord("Asian Elephant", 12, "2025-08-01"),
                new CensusRecord("Bengal Tiger", 3, "2025-08-01"),
                new CensusRecord("Hoolock Gibbon", 8, "2025-08-02")
        );

        censusTable.setItems(censusList);

        // Button actions
        updateButton.setOnAction(e -> updateCensus());
        backButton.setOnAction(this::goBack);
    }

    // Handle updating census
    private void updateCensus() {
        System.out.println("Updating census for date: " + datePicker.getValue());
        for (CensusRecord record : censusList) {
            System.out.println(record.getSpecies() + " - " + record.getCount() + " recorded on " + record.getDate());
        }
    }

    // Back navigation
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
    public static class CensusRecord {
        private String species;
        private int count;
        private String date;

        public CensusRecord(String species, int count, String date) {
            this.species = species;
            this.count = count;
            this.date = date;
        }

        public String getSpecies() { return species; }
        public int getCount() { return count; }
        public String getDate() { return date; }
    }
}
