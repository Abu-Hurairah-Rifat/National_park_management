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
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class PermitOfficerCancelPermitController {

    @FXML
    private TableColumn<?, ?> emailTableColumn;

    @FXML
    private TableColumn<?, ?> noOfVisitorsTableColumn;

    @FXML
    private TableView<?> permitDataTableView;

    @FXML
    private TextField permitIDtextField;

    @FXML
    private TableColumn<?, ?> permitIdTableColumn;

    @FXML
    private TableColumn<?, ?> permitTypeTableColumn;

    @FXML
    private TableColumn<?, ?> phoneTableColumn;

    @FXML
    private Label showSearchResultLabel;

    @FXML
    private TableColumn<?, ?> totalFeeTableColumn;

    @FXML
    private TableColumn<?, ?> visitDateTableColumn;

    @FXML
    private TableColumn<?, ?> visitorNameTableColumn;

    @FXML
    private TextField visitorNameTextField;

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
    void cancelPermitButton(ActionEvent event) {

    }

    @FXML
    void searchPermitsButton(ActionEvent event) {

    }

    @FXML
    void viewAllPermitsButton(ActionEvent event) {

    }

}
