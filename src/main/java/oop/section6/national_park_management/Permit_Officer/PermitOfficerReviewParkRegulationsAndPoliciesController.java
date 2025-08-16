package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class PermitOfficerReviewParkRegulationsAndPoliciesController {

    @FXML
    private Label parkRegulationsAndPoliciesLabel;

    @FXML
    void backToDashboardButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/Permit_Officer_Main_Dashboard.fxml"));
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
    public void PrintInformation(){
        parkRegulationsAndPoliciesLabel.setText(
                "1. Wildlife (Preservation) Order of 1974 / National Park Notification (1996)\n" +
                "\n" +
                "Lawachara NP was legally declared in 1996 under the Wildlife (Preservation) Order of 1974,"+ "\n"+
                "which serves as the foundation for park protection and conservation in Bangladesh.\n" +
                "\n" +
                "2. Simplified Management Guidelines (2006) – Nishorgo Support Project\n" +
                "\n" +
                "This document outlines key operational policies and management strategies for Lawachara NP. Notable areas include:\n" +
                "Habitat Protection: Conservation of remaining ecosystems and enrichment planting of indigenous species.\n" +
                "Zoning: Separation into core, buffer, and landscape zones, each with distinct management prescriptions.\n" +
                "Community Co-Management: Incorporation of local stakeholders in benefit-sharing and sustainable livelihood initiatives.\n" +
                "Facilities & Infrastructure: Guidelines for trails, signage, visitor accommodations, litter management, and administrative structures.\n" +
                "\n" +
                "3. Comprehensive Management Plan – Nishorgo Support Project\n" +
                "\n" +
                "This broader five-year plan complements the Simplified Guidelines, including:\n" +
                "Administrative roles and staffing structures.\n" +
                "Funding frameworks and budget management.\n" +
                "Detailed zoning prescriptions and monitoring systems.\n" +
                "\n" +
                "4. Visitor-Specific Regulations\n" +
                "\n" +
                "According to visitor guidance sources, important rules include:\n" +
                "No littering.\n" +
                "Do not remove or disturb wildlife and plant life.\n" +
                "Respect ecosystem boundaries and behavior guidelines.");
    }



}
