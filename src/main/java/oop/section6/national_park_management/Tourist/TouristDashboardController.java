package oop.section6.national_park_management.Tourist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class TouristDashboardController {

    @FXML
    private BorderPane touristDashboardBorderPane;

    @FXML
    void handleFindRateGuideClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/findAnd_RateGuide.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleLogoutClick(ActionEvent event) {
        System.out.println("Logout button clicked. Returning to login screen...");
    }

    @FXML
    void handleManageTicketsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/manage-tickets.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleParkInfoClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/park-info.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handlePlanItineraryClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/plan-Itinerary.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleProvideFeedbackClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/provide-feedback.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handlePurchaseTicketsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/purchase_tickets-view.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleReportIssueClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/report_issues.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleWildlifeChecklistClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/section6/national_park_management/Tourist/wildlife-checklist.fxml"));
            touristDashboardBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}