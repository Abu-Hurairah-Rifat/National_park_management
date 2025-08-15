package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ManageBookingsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button acceptButton;
    @FXML
    private Button declineButton;
    @FXML
    private Label groupSizeLabel;
    @FXML
    private ListView<BookingRequest> pendingRequestsList;
    @FXML
    private Label statusLabel;
    @FXML
    private Label tourDateLabel;
    @FXML
    private Label touristNameLabel;

    @FXML
    void initialize() {
        setupListView();
        setupButtons();
        clearDetailsPane();
    }

    private void setupListView() {
        ObservableList<BookingRequest> requests = FXCollections.observableArrayList(
                new BookingRequest("Ayesha Siddiqa", "2025-08-25", 4, "Pending"),
                new BookingRequest("Sheikh Nirjhor", "2025-09-02", 2, "Pending"),
                new BookingRequest("Tasnim Binte Rabbani", "2025-09-10", 3, "Pending")
        );
        pendingRequestsList.setItems(requests);

        pendingRequestsList.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(BookingRequest item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    textProperty().bind(item.statusProperty().map(status -> item.getTouristName() + " (" + status + ")"));
                }
            }
        });

        pendingRequestsList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> showRequestDetails(newSelection)
        );
    }

    private void setupButtons() {
        acceptButton.setOnAction(event -> handleDecision("Accepted"));
        declineButton.setOnAction(event -> handleDecision("Declined"));
    }

    private void showRequestDetails(BookingRequest request) {
        if (request != null) {
            touristNameLabel.setText(request.getTouristName());
            tourDateLabel.setText(request.getVisitDate());
            groupSizeLabel.setText(String.valueOf(request.getGroupSize()));
            statusLabel.setText("Status: " + request.getStatus());

            boolean isPending = request.getStatus().equals("Pending");
            acceptButton.setDisable(!isPending);
            declineButton.setDisable(!isPending);
        } else {
            clearDetailsPane();
        }
    }

    private void handleDecision(String decision) {
        BookingRequest selected = pendingRequestsList.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getStatus().equals("Pending")) {
            selected.setStatus(decision);
            showRequestDetails(selected); // Refresh details pane
        }
    }

    private void clearDetailsPane() {
        touristNameLabel.setText("N/A");
        tourDateLabel.setText("N/A");
        groupSizeLabel.setText("N/A");
        statusLabel.setText("Select a request to view details");
        acceptButton.setDisable(true);
        declineButton.setDisable(true);
    }

    public static class BookingRequest {
        private final StringProperty touristName;
        private final StringProperty visitDate;
        private final int groupSize;
        private final StringProperty status;

        public BookingRequest(String name, String date, int size, String initialStatus) {
            this.touristName = new SimpleStringProperty(name);
            this.visitDate = new SimpleStringProperty(date);
            this.groupSize = size;
            this.status = new SimpleStringProperty(initialStatus);
        }

        public String getTouristName() { return touristName.get(); }
        public String getVisitDate() { return visitDate.get(); }
        public int getGroupSize() { return groupSize; }
        public String getStatus() { return status.get(); }
        public void setStatus(String status) { this.status.set(status); }

        public StringProperty statusProperty() { return status; }
    }
}