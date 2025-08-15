package oop.section6.national_park_management.EcoTourGuide;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class EcoTourGuideDashboardController {

    @FXML
    private BorderPane ecoTourGuideDashboardBorderPane;

    @FXML
    void handleManageScheduleClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/manage-schedule.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBookingRequestsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/manage-bookings.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleAlertsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/operational-alerts.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleMessagesClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/client-messages.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleProfileClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/maintain-profile.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleEarningsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/earnings-history.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleMapsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/advanced-maps.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleRatingsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/EcoTourGuide/view-ratings.fxml"));
            ecoTourGuideDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleLogoutClick(ActionEvent event) {
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