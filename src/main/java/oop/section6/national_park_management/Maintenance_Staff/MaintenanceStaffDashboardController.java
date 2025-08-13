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

    }

    @FXML
    void requestSuppliesOrEquipmentButton(ActionEvent event) {

    }

    @FXML
    void updateIssueStatusButton(ActionEvent event) {

    }

    @FXML
    void viewInventoryButton(ActionEvent event) {

    }

    @FXML
    void viewIssuesButton(ActionEvent event) {

    }

    @FXML
    void viewSchedulesTasksButton(ActionEvent event) {

    }

    @FXML
    public void assignMaintenanceTasksButton(ActionEvent actionEvent) {
    }
}
