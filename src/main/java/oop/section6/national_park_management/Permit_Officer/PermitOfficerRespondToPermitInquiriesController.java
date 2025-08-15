package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class PermitOfficerRespondToPermitInquiriesController {

    @FXML
    private TableColumn<?, ?> inquiryDetailsTableColumn;

    @FXML
    private TableColumn<?, ?> inquiryEmailTableColumn;

    @FXML
    private TableColumn<?, ?> inquiryIdTableColumn;

    @FXML
    private TableColumn<?, ?> inquiryNameTableColumn;

    @FXML
    private TableColumn<?, ?> inquirySubmissionDateTableColumn;

    @FXML
    private TableView<?> permitInquiriesTableView;

    @FXML
    private TextField responseEmailTextField;

    @FXML
    private TextArea responseMessageTextArea;

    @FXML
    void sendResponseButton(ActionEvent event) {

    }

    @FXML
    void viewInquiriesButton(ActionEvent event) {

    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/Permit_Officer_Main_Dashboard.fxml"));
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
