package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class SetEntryFeeRatesController {

    @FXML
    private TextField adultFeeField;

    @FXML
    private TextField childFeeField;

    @FXML
    private TextField foreignerFeeField;

    @FXML
    private Button saveFeeBtn;

    @FXML
    private void initialize() {
        System.out.println("SetEntryFeeRatesController initialized.");
        // TODO: Load current rates into fields if available
    }

    @FXML
    private void handleSaveFees(ActionEvent event) {
        String adultFee = adultFeeField.getText();
        String childFee = childFeeField.getText();
        String foreignerFee = foreignerFeeField.getText();

        // TODO: Save these rates into database or config
        System.out.println("Saving fees: Adult=" + adultFee +
                ", Child=" + childFee +
                ", Foreigner=" + foreignerFee);
    }
}
