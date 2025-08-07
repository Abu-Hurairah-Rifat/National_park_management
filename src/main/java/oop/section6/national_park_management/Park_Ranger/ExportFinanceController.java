package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ExportFinanceController {

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<String> yearComboBox;

    @FXML
    private Button exportBtn;

    @FXML
    private void initialize() {
        monthComboBox.getItems().addAll(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        );

        yearComboBox.getItems().addAll("2023", "2024", "2025");
    }

    @FXML
    private void handleExportReport(ActionEvent event) {
        String selectedMonth = monthComboBox.getValue();
        String selectedYear = yearComboBox.getValue();

        if (selectedMonth == null || selectedYear == null) {
            System.out.println("Please select both month and year.");
            return;
        }

        System.out.println("Exporting Financial Report for: " + selectedMonth + " " + selectedYear);
        // TODO: Generate actual PDF report
    }
}
