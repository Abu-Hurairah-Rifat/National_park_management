package oop.section6.national_park_management.Tourist;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class PurchaseTicketsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label bookingIdLabel;
    @FXML
    private Button confirmPaymentButton;
    @FXML
    private VBox confirmationVBox;
    @FXML
    private Button myTicketsButton;
    @FXML
    private Spinner<Integer> numberOfTicketsSpinner;
    @FXML
    private TextField paymentDetailsField;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    @FXML
    private Label totalCostLabel;
    @FXML
    private DatePicker visitDatePicker;

    private static final double TICKET_PRICE = 50.00;

    @FXML
    void initialize() {
        setupSpinner();
        setupComboBox();

        confirmationVBox.setVisible(false);
        confirmationVBox.setManaged(false);

        numberOfTicketsSpinner.valueProperty().addListener((obs, oldValue, newValue) -> updateTotalCost());
        updateTotalCost();

        confirmPaymentButton.setOnAction(this::handlePaymentConfirmation);
    }

    private void setupSpinner() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 1);
        numberOfTicketsSpinner.setValueFactory(valueFactory);
    }

    private void setupComboBox() {
        paymentMethodComboBox.setItems(FXCollections.observableArrayList(
                "Credit/Debit Card", "bKash", "Nagad", "Rocket"
        ));
    }

    private void updateTotalCost() {
        int quantity = numberOfTicketsSpinner.getValue();
        double total = quantity * TICKET_PRICE;
        totalCostLabel.setText(String.format("Total Cost: ৳%.2f", total));
    }

    private void handlePaymentConfirmation(ActionEvent event) {
        if (!isInputValid()) {
            return;
        }

        String bookingId = "LNP-" + (100000 + new Random().nextInt(900000));
        bookingIdLabel.setText(bookingId);

        setPurchaseCompleteUIState(true);
    }

    private boolean isInputValid() {
        if (visitDatePicker.getValue() == null) {
            showAlert("Validation Error", "Please select a valid visit date.");
            return false;
        }
        if (paymentMethodComboBox.getSelectionModel().isEmpty()) {
            showAlert("Validation Error", "Please select a payment method.");
            return false;
        }
        if (paymentDetailsField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please enter your payment account details.");
            return false;
        }
        return true;
    }

    private void setPurchaseCompleteUIState(boolean isComplete) {
        confirmationVBox.setVisible(isComplete);
        confirmationVBox.setManaged(isComplete);

        confirmPaymentButton.setDisable(isComplete);
        visitDatePicker.setDisable(isComplete);
        numberOfTicketsSpinner.setDisable(isComplete);
        paymentMethodComboBox.setDisable(isComplete);
        paymentDetailsField.setDisable(isComplete);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}