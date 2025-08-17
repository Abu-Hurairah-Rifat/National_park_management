package oop.section6.national_park_management.wildlife;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TeamCollaborationController
{
    @javafx.fxml.FXML
    private TextArea teamNotes;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Team_Collaboration.fxml"));
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
    public void saveNotes(ActionEvent actionEvent) {
        if (teamNotes.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Notes");
            alert.setContentText("Please enter some notes before saving.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Notes Saved");
            alert.setContentText("Your team notes have been saved successfully.");
            alert.showAndWait();
        }
    }
}