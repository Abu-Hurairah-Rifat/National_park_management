package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class MaintenanceStaffDashboardController {

    @FXML
    void recordWorkLogButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Work_Logs.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void reportNewIssueButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Report_New_Maintenance_Issue.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void requestSuppliesOrEquipmentButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Request_Supplies_Equipment.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void updateIssueStatusButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Update_Maintenance_Issue_Status.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void viewInventoryButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/View_Maintenance_Supplies.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void viewIssuesButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/View_Existing_Maintenance_Issues.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void viewSchedulesTasksButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/View_Schedules_Preventative_Tasks.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    public void assignMaintenanceTasksButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Assign_Maintenance_Task.fxml"));
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
