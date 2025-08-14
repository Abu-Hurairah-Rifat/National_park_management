package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class PermitOfficerMainDashboardController {
    @FXML
    private BorderPane permitOfficerMainDashboardBorderPane;

    @javafx.fxml.FXML
    public void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permit_officer_dashboard.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    @FXML
    void cancelPermitButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Cancel_Permit.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void dashboardOfPermitOfficerButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permit_officer_dashboard.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void editPermitsButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Modify_Permits.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void generateReportsButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Generate_Visitor_Reports.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void issueNewPermitButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/PermitOfficer_Issue_new_permit.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void manageParkCapacityAndClosuresButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Manage_Park_CapacityOrClosures.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void parkRegulationsAndPoliciesButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Review_Park_Regulations_and_Policies.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void viewInquiriesButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Respond_to_Permit_Inquiries.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void viewPermitsButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/PermitOfficer_view_Permits.fxml"));
            permitOfficerMainDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void logOutButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("log-in-view.fxml"));
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

}
