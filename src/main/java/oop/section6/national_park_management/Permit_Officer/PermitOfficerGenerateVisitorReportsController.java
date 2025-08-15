package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class PermitOfficerGenerateVisitorReportsController {

    @FXML
    private TableColumn<?, ?> emailTableColumn;

    @FXML
    private TableColumn<?, ?> noOfVisitorsTableColumn;

    @FXML
    private TableView<?> permitDataTableView;

    @FXML
    private TableColumn<?, ?> permitIdTableColumn;

    @FXML
    private TableColumn<?, ?> permitTypeTableColumn;

    @FXML
    private TableColumn<?, ?> phoneTableColumn;

    @FXML
    private TableColumn<?, ?> totalFeeTableColumn;

    @FXML
    private TableColumn<?, ?> visitDateTableColumn;

    @FXML
    private TableColumn<?, ?> visitorNameTableColumn;

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
    void generateDailyReportButton(ActionEvent event) {

    }

    @FXML
    void generateReportButton(ActionEvent event) {

    }

    @FXML
    void generateWeeklyReportButton(ActionEvent event) {

    }

    @FXML
    void viewAllPermitsButton(ActionEvent event) {

    }

}
