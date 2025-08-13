package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class MaintenanceStaffMainDashboardController
{
    @javafx.fxml.FXML
    private BorderPane maintenceStaffMainDashboardBorderPane;

    @javafx.fxml.FXML
    public void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Staff_dashboard.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void dashboardOfMaintenanceStaffButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Staff_dashboard.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void updateIssueStatusButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Update_Maintenance_Issue_Status.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void viewInventory(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/View_Maintenance_Supplies.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void requestSuppliesButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Request_Supplies_Equipment.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void reportNewIssueButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Report_New_Maintenance_Issue.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void assignToMeButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Assign_Maintenance_Task.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void recordWorkLogButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Work_Logs.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void viewIssueButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/View_Existing_Maintenance_Issues.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void viewScheduleButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/View_Schedules_Preventative_Tasks.fxml"));
            maintenceStaffMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("log-in-view.fxml"));
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