package oop.section6.national_park_management.wildlife;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class ResearcherMainDashboard
{
    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void teamCollaboration(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Team_Collaboration.fxml"));
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
    public void submitObservation(ActionEvent actionEvent) {
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
    public void trackEquipment(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Track_Equipment.fxml"));
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
    public void requestExport(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Request_Export.fxml"));
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
    public void viewHistoricalData(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Historical_Data.fxml"));
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
    public void logEnvironment(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Log_Environment.fxml"));
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
    public void requestPermit(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Request_Permit.fxml"));
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
    public void submitReport(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Submit_Report.fxml"));
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
}