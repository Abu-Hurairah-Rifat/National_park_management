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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

        if (speciesField.getText().isEmpty() || locationField.getText().isEmpty() || datePicker.getValue() == null) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Required fields are empty");
            alert.setContentText("Please fill in all required fields:\n- Species\n- Location\n- Date");

            alert.showAndWait();
        } else {

            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText("Observation Submitted");
            successAlert.setContentText("Your wildlife observation has been recorded.");

            successAlert.showAndWait();

            speciesField.clear();
            locationField.clear();
            notesArea.clear();
            datePicker.setValue(null);
        }
    }
}