package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class PermitOfficerModifyPermitsFormController {

    @FXML
    private TableColumn<?, ?> emailTableColumn;

    @FXML
    private TextField emailTextField;

    @FXML
    private TableColumn<?, ?> noOfVisitorsTableColumn;

    @FXML
    private TextField noOfVisitorsTextField;

    @FXML
    private TableView<?> permitDataTableView;

    @FXML
    private TableColumn<?, ?> permitIdTableColumn;

    @FXML
    private ComboBox<?> permitTypeComboBox;

    @FXML
    private TableColumn<?, ?> permitTypeTableColumn;

    @FXML
    private TableColumn<?, ?> phoneTableColumn;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TableColumn<?, ?> totalFeeTableColumn;

    @FXML
    private DatePicker visitDateDatePicker;

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
    void updatePermitButton(ActionEvent event) {

    }

}
