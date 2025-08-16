package oop.section6.national_park_management.wildlife;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class SubmitObservationController
{
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private TextArea notesArea;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField speciesField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Submit_Observation.fxml"));
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
    public void submit(ActionEvent actionEvent) {
    }
}