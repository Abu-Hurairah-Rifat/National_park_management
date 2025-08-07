package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PermitOfficerModifyPermitsController {

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
    void modifyPermitsButton(ActionEvent event) {

    }

    @FXML
    void searchPermitsButton(ActionEvent event) {

    }

    @FXML
    void viewAllPermitsButton(ActionEvent event) {

    }

}
