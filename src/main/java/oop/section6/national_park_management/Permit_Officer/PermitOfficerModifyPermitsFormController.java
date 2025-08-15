package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

import java.util.ArrayList;

public class PermitOfficerModifyPermitsFormController {

    @FXML
    private TableColumn<IssuePermit, String> emailTableColumn;

    @FXML
    private TextField emailTextField;

    @FXML
    private TableColumn<IssuePermit, String> noOfVisitorsTableColumn;

    @FXML
    private TextField noOfVisitorsTextField;

    @FXML
    private TableView<IssuePermit> permitDataTableView;

    @FXML
    private TableColumn<IssuePermit, String> permitIdTableColumn;

    @FXML
    private ComboBox<String> permitTypeComboBox;

    @FXML
    private TableColumn<IssuePermit, String> permitTypeTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> phoneTableColumn;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TableColumn<IssuePermit, String> totalFeeTableColumn;

    @FXML
    private DatePicker visitDateDatePicker;

    @FXML
    private TableColumn<IssuePermit, String> visitDateTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> visitorNameTableColumn;

    @FXML
    private TextField visitorNameTextField;

    ArrayList IssuePermitList = new ArrayList<String>();

    @FXML
    void backToDashboardButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Modify_Permits.fxml"));
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
    void updatePermitButton(ActionEvent event) {

        Alert updateMessageAlert = new Alert(Alert.AlertType.INFORMATION);
        updateMessageAlert.setContentText("All information are successfully updated.");
        updateMessageAlert.show();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Modify_Permits.fxml"));
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

    public void initialize(){
        IssuePermitList = new ArrayList<>();
        permitIdTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("id"));
        visitorNameTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("name"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("email"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("phone"));
        permitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("permitType"));
        noOfVisitorsTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("noOfVisitor"));
        visitDateTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("visitDate"));
        totalFeeTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("price"));
    }

}
