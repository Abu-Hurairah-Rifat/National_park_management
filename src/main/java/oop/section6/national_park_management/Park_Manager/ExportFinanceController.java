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

public class ExportFinanceController {

    @FXML private Button backButton;
    @FXML private DatePicker fromDatePicker;
    @FXML private DatePicker toDatePicker;
    @FXML private TableView<FinanceReport> reportTable;
    @FXML private TableColumn<FinanceReport, String> colDate;
    @FXML private TableColumn<FinanceReport, String> colDescription;
    @FXML private TableColumn<FinanceReport, Double> colAmount;
    @FXML private Button exportButton;

    protected ObservableList<FinanceReport> financeList;

    @FXML
    public void initialize() {
        // Set up table columns
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Dummy Data
        financeList = FXCollections.observableArrayList(
                new FinanceReport("2025-08-01", "Entry Fees", 1500.0),
                new FinanceReport("2025-08-02", "Guided Tour", 750.0),
                new FinanceReport("2025-08-03", "Souvenir Sales", 320.0)
        );

        reportTable.setItems(financeList);

        // Export Button Action
        exportButton.setOnAction(e -> exportToPDF());

        // Back Button Action
        backButton.setOnAction(this::goBack);
    }

    private void exportToPDF() {
        System.out.println("Exporting to PDF...");
        System.out.println("From: " + fromDatePicker.getValue() + " To: " + toDatePicker.getValue());
        for (FinanceReport report : reportTable.getItems()) {
            System.out.println(report.getDate() + " | " + report.getDescription() + " | $" + report.getAmount());
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
    public static class FinanceReport {
        private final String date;
        private String description;
        private Double amount;

        public FinanceReport(String date, String description, Double amount) {
            this.date = date;
            this.description = description;
            this.amount = amount;
        }

        public String getDate() { return date; }
        public String getDescription() { return description; }
        public Double getAmount() { return amount; }
    }
}
