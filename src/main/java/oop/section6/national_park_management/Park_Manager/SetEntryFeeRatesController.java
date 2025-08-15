package oop.section6.national_park_management.Park_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;

public class SetEntryFeeRatesController {

    @FXML private Button backButton;
    @FXML private TableView<FeeRate> feeTable;
    @FXML private TableColumn<FeeRate, String> colCategory;
    @FXML private TableColumn<FeeRate, String> colRate;
    @FXML private Button updateFeeButton;

    private ObservableList<FeeRate> feeList;

    @FXML
    public void initialize() {
        // Bind table columns
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colRate.setCellValueFactory(new PropertyValueFactory<>("rate"));

        // Dummy data for preview
        feeList = FXCollections.observableArrayList(
                new FeeRate("Local Adult", "$5"),
                new FeeRate("Local Child", "$2"),
                new FeeRate("Foreign Tourist", "$15"),
                new FeeRate("Student (with ID)", "$3")
        );

        feeTable.setItems(feeList);

        // Actions
        updateFeeButton.setOnAction(e -> updateFees());
        backButton.setOnAction(this::goBack);
    }

    private void updateFees() {
        FeeRate selected = feeTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            JOptionPane.showMessageDialog(null,
                    "Fee rate for '" + selected.getCategory() + "' updated successfully.",
                    "Fee Update", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please select a category to update.",
                    "No Selection", JOptionPane.WARNING_MESSAGE);
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
    // Model class
    public static class FeeRate {
        private String category;
        private String rate;

        public FeeRate(String category, String rate) {
            this.category = category;
            this.rate = rate;
        }

        public String getCategory() { return category; }
        public String getRate() { return rate; }
    }
}
