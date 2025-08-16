package oop.section6.national_park_management.conservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class MonitorHabitatController
{
    @javafx.fxml.FXML
    private TextArea notesArea;
    @javafx.fxml.FXML
    private ComboBox regionCombo;
    @javafx.fxml.FXML
    private TableView indicatorsTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ConservatinDataAnalyst/Analyst_Monitor_Habitat.fxml"));
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
    public void saveAssessment(ActionEvent actionEvent) {
    }
}