package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class OperationalAlertsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button acknowledgeButton;
    @FXML
    private TextArea alertDetailsArea;
    @FXML
    private ListView<AlertMessage> alertsListView;

    private record AlertMessage(String title, String content, boolean isHighPriority) {
        @Override
        public String toString() {
            return (isHighPriority ? "[URGENT] " : "") + title;
        }
    }

    @FXML
    void initialize() {
        setupListView();
        setupButtonActions();
        clearDetailsPane();
    }

    private void setupListView() {
        ObservableList<AlertMessage> alerts = FXCollections.observableArrayList(
                new AlertMessage("High Priority: Trail Closure", "The main Waterfall Trail is closed until 14:00 today due to a fallen tree. Please use alternate routes.", true),
                new AlertMessage("Wildlife Sighting", "A family of Hoolock Gibbons has been spotted near the Canopy Walkway. Advise tourists to keep a safe distance.", false),
                new AlertMessage("Weather Warning", "A sudden downpour is expected around 15:30. Ensure all tours are heading back to the visitor center by 15:00.", true),
                new AlertMessage("General Notice", "The park will close 30 minutes early today for a staff meeting.", false)
        );
        alertsListView.setItems(alerts);

        alertsListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> showDetails(newVal)
        );
    }

    private void setupButtonActions() {
        acknowledgeButton.setOnAction(event -> handleAcknowledge());
    }

    private void showDetails(AlertMessage alert) {
        if (alert != null) {
            alertDetailsArea.setText(alert.content());
            acknowledgeButton.setVisible(alert.isHighPriority());
            acknowledgeButton.setDisable(false);
            acknowledgeButton.setText("Acknowledge High-Priority Alert");
        } else {
            clearDetailsPane();
        }
    }

    private void handleAcknowledge() {
        AlertMessage selected = alertsListView.getSelectionModel().getSelectedItem();
        if (selected != null && selected.isHighPriority()) {
            System.out.println("Alert Acknowledged: " + selected.title());
            acknowledgeButton.setText("Acknowledged");
            acknowledgeButton.setDisable(true);
        }
    }

    private void clearDetailsPane() {
        alertDetailsArea.clear();
        acknowledgeButton.setVisible(false);
    }
}