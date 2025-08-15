package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EarningsHistoryController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableColumn<TourRecord, String> clientCol;
    @FXML
    private TableColumn<TourRecord, String> dateCol;
    @FXML
    private TableColumn<TourRecord, Double> earningsCol;
    @FXML
    private Label monthlyEarningsLabel;
    @FXML
    private Button payoutsButton;
    @FXML
    private TextField searchHistoryField;
    @FXML
    private TableView<TourRecord> tourHistoryTable;
    @FXML
    private Label ytdEarningsLabel;

    private ObservableList<TourRecord> allTours;

    public record TourRecord(String date, String client, Double earnings) {}

    @FXML
    void initialize() {
        setupSummaryLabels();
        setupTableColumns();
        loadSampleData();
        setupSearchFilter();

        payoutsButton.setOnAction(e -> System.out.println("Navigating to Payouts and Bank Info page..."));
    }

    private void setupSummaryLabels() {
        monthlyEarningsLabel.setText("This Month's Earnings: ৳15,000.00");
        ytdEarningsLabel.setText("Year-to-Date Earnings: ৳125,000.00");
    }

    private void setupTableColumns() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("client"));
        earningsCol.setCellValueFactory(new PropertyValueFactory<>("earnings"));
    }

    private void loadSampleData() {
        allTours = FXCollections.observableArrayList(
                new TourRecord("2025-08-05", "Ayesha Siddiqa", 3000.00),
                new TourRecord("2025-07-21", "Tasnim Binte Rabbani", 2500.00),
                new TourRecord("2025-07-15", "Abu Hurairah Rifat", 4000.00),
                new TourRecord("2025-06-28", "Sheikh Nirjhor", 3200.00)
        );
    }

    private void setupSearchFilter() {
        FilteredList<TourRecord> filteredData = new FilteredList<>(allTours, p -> true);

        searchHistoryField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(tourRecord -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (tourRecord.client().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (tourRecord.date().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        tourHistoryTable.setItems(filteredData);
    }
}