package oop.section6.national_park_management.conservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

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
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void exportData(ActionEvent actionEvent) {
    }
}