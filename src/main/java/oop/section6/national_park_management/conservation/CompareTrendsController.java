package oop.section6.national_park_management.conservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CompareTrendsController
{
    @javafx.fxml.FXML
    private ComboBox species1Combo;
    @javafx.fxml.FXML
    private ComboBox species2Combo;
    @javafx.fxml.FXML
    private TextField startYear;
    @javafx.fxml.FXML
    private TextArea comparisonResults;
    @javafx.fxml.FXML
    private TextField endYear;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ConservatinDataAnalyst/Analyst_Compare_Trends.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void compare(ActionEvent actionEvent) {
        if (species1Combo.getValue() == null || species2Combo.getValue() == null ||
                startYear.getText().isEmpty() || endYear.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please select both species and enter year range.");
            alert.showAndWait();
        }
    }
}