package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

import java.util.ArrayList;

public class PermitOfficerModifyPermitsController {

    @FXML
    private TableColumn<IssuePermit, String> emailTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> noOfVisitorsTableColumn;

    @FXML
    private TableView<IssuePermit> permitDataTableView;

    @FXML
    private TableColumn<IssuePermit, String> permitIdTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> permitTypeTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> phoneTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> totalFeeTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> visitDateTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> visitorNameTableColumn;

    @FXML
    private TextField visitorNameTextField;
    @FXML
    private Label showSearchResultLabel;
    @FXML
    private TextField permitIDtextField;

    ArrayList IssuePermitList = new ArrayList<String>();

    @FXML
    void modifyPermitsButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Modify_PermitsForm.fxml"));
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
    void searchPermitsButton(ActionEvent event) {

    }

    @FXML
    void viewAllPermitsButton(ActionEvent event) {


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

    @Deprecated
    public void issuePermitButton(ActionEvent actionEvent) {

    }

    @FXML
    void initialize(){
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
