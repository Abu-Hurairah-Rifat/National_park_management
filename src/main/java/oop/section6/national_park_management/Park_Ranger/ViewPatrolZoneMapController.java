package oop.section6.national_park_management.Park_Ranger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ViewPatrolZoneMapController {

    @FXML
    private DatePicker mapDatePicker;

    @FXML
    private TableView<ZoneData> zoneTable;

    @FXML
    private TableColumn<ZoneData, String> colZoneID;

    @FXML
    private TableColumn<ZoneData, String> colZoneName;

    @FXML
    private TableColumn<ZoneData, String> colStatus;

    @FXML
    private Button backButton;

    @FXML
    private Button viewMapButton;

    @FXML
    public void initialize() {
        // Link columns to ZoneData properties
        colZoneID.setCellValueFactory(data -> data.getValue().zoneIDProperty());
        colZoneName.setCellValueFactory(data -> data.getValue().zoneNameProperty());
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());

        // Default date to today
        mapDatePicker.setValue(LocalDate.now());

        // Load data when "View Map" button is clicked
        viewMapButton.setOnAction(e -> loadZoneData());
    }

    private void loadZoneData() {
        LocalDate selectedDate = mapDatePicker.getValue();
        if (selectedDate == null) {
            showAlert("Please select a date before viewing.");
            return;
        }

        // Mock patrol zone data (replace with DB query)
        ObservableList<ZoneData> data = FXCollections.observableArrayList(
                new ZoneData("Z1", "North Sector", "Patrolled"),
                new ZoneData("Z2", "West Hills", "Pending"),
                new ZoneData("Z3", "River Delta", "Patrolled")
        );

        zoneTable.setItems(data);
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/oop/section6/national_park_management/Park Ranger/ParkRangerDashboard.fxml"
            ));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Park Ranger Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Inner model class for patrol zone data
     */
    public static class ZoneData {
        private final javafx.beans.property.SimpleStringProperty zoneID;
        private final javafx.beans.property.SimpleStringProperty zoneName;
        private final javafx.beans.property.SimpleStringProperty status;

        public ZoneData(String zoneID, String zoneName, String status) {
            this.zoneID = new javafx.beans.property.SimpleStringProperty(zoneID);
            this.zoneName = new javafx.beans.property.SimpleStringProperty(zoneName);
            this.status = new javafx.beans.property.SimpleStringProperty(status);
        }

        public javafx.beans.property.StringProperty zoneIDProperty() { return zoneID; }
        public javafx.beans.property.StringProperty zoneNameProperty() { return zoneName; }
        public javafx.beans.property.StringProperty statusProperty() { return status; }
    }
}
