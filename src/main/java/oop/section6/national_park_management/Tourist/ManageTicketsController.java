package oop.section6.national_park_management.Tourist;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ManageTicketsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label bookingIdLabel;
    @FXML
    private Button cancelTicketButton;
    @FXML
    private Label cancellationStatusLabel;
    @FXML
    private VBox detailsPane;
    @FXML
    private TableColumn<Ticket, String> pastBookingIdCol;
    @FXML
    private TableColumn<Ticket, String> pastDateCol;
    @FXML
    private TableColumn<Ticket, String> pastStatusCol;
    @FXML
    private TableView<Ticket> pastTicketsTable;
    @FXML
    private ImageView qrCodeImageView;
    @FXML
    private Label statusLabel;
    @FXML
    private TableColumn<Ticket, String> upcomingBookingIdCol;
    @FXML
    private TableColumn<Ticket, String> upcomingDateCol;
    @FXML
    private TableColumn<Ticket, String> upcomingStatusCol;
    @FXML
    private TableView<Ticket> upcomingTicketsTable;
    @FXML
    private Label visitDateLabel;

    private ObservableList<Ticket> upcomingTickets;
    private ObservableList<Ticket> pastTickets;

    @FXML
    void initialize() {
        detailsPane.setVisible(false);

        setupTableColumns();
        loadSampleData();
        setupTableListeners();

        cancelTicketButton.setOnAction(event -> handleCancelTicket());
    }

    private void setupTableColumns() {
        upcomingBookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        upcomingDateCol.setCellValueFactory(new PropertyValueFactory<>("visitDate"));
        upcomingStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        pastBookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        pastDateCol.setCellValueFactory(new PropertyValueFactory<>("visitDate"));
        pastStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadSampleData() {
        upcomingTickets = FXCollections.observableArrayList(
                new Ticket("NPT-20250820-A1B2", LocalDate.of(2025, 8, 20), "Confirmed"),
                new Ticket("NPT-20250905-C3D4", LocalDate.of(2025, 9, 5), "Confirmed")
        );
        upcomingTicketsTable.setItems(upcomingTickets);

        pastTickets = FXCollections.observableArrayList(
                new Ticket("NPT-20250715-E5F6", LocalDate.of(2025, 7, 15), "Used"),
                new Ticket("NPT-20250610-G7H8", LocalDate.of(2025, 6, 10), "Cancelled")
        );
        pastTicketsTable.setItems(pastTickets);
    }

    private void setupTableListeners() {
        upcomingTicketsTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> showTicketDetails(newSelection));

        pastTicketsTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> showTicketDetails(newSelection));
    }

    private void showTicketDetails(Ticket ticket) {
        if (ticket != null) {
            detailsPane.setVisible(true);
            bookingIdLabel.setText(ticket.getBookingId());
            visitDateLabel.setText(ticket.getVisitDate().toString());
            statusLabel.setText(ticket.getStatus());
            cancellationStatusLabel.setText("");

            Image qrPlaceholder = new Image(getClass().getResourceAsStream("/oop/section6/national_park_management/Tourist/placeholder_qr.png"));
            qrCodeImageView.setImage(qrPlaceholder);

            cancelTicketButton.setDisable(!ticket.getStatus().equals("Confirmed"));
        } else {
            detailsPane.setVisible(false);
        }
    }

    private void handleCancelTicket() {
        Ticket selectedTicket = upcomingTicketsTable.getSelectionModel().getSelectedItem();
        if (selectedTicket != null && selectedTicket.getStatus().equals("Confirmed")) {
            selectedTicket.setStatus("Cancelled");
            upcomingTicketsTable.refresh();
            showTicketDetails(selectedTicket);
            cancellationStatusLabel.setText("Ticket has been cancelled.");
        }
    }

    public static class Ticket {
        private final StringProperty bookingId;
        private final StringProperty visitDate;
        private final StringProperty status;

        public Ticket(String bookingId, LocalDate visitDate, String status) {
            this.bookingId = new SimpleStringProperty(bookingId);
            this.visitDate = new SimpleStringProperty(visitDate.toString());
            this.status = new SimpleStringProperty(status);
        }

        public String getBookingId() { return bookingId.get(); }
        public String getVisitDate() { return visitDate.get(); }
        public String getStatus() { return status.get(); }
        public void setStatus(String status) { this.status.set(status); }

        public StringProperty bookingIdProperty() { return bookingId; }
        public StringProperty visitDateProperty() { return visitDate; }
        public StringProperty statusProperty() { return status; }
    }
}