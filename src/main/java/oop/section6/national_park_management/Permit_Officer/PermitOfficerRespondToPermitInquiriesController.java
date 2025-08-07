package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PermitOfficerRespondToPermitInquiriesController {

    @FXML
    private Button backToDashboardButton;

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

}
