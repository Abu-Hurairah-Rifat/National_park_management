package oop.section6.national_park_management.conservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExportDatasetsController
{
    @javafx.fxml.FXML
    private ComboBox datasetCombo;
    @javafx.fxml.FXML
    private ComboBox formatCombo;
    @javafx.fxml.FXML
    private TextArea parametersArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ConservatinDataAnalyst/Analyst_Export_Datasets.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void exportData(ActionEvent actionEvent) {
        if (datasetCombo.getValue() == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Dataset Selected");
            alert.setContentText("Please select a dataset to export.");
            alert.showAndWait();
            return;
        }

        Alert successAlert = new Alert(AlertType.INFORMATION);
        successAlert.setTitle("Success");
        successAlert.setHeaderText("Export Started");
        successAlert.setContentText("Dataset export process has begun.");
        successAlert.showAndWait();
    }
}