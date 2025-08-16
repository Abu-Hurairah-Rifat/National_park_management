package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class AssignMaintenanceTaskController {

    @FXML
    private TableColumn<MaintenanceIssue, String> issueDescriptionTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueIdTableColumn;

    @FXML
    private TextField issueIdTextField;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueTypeTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> locationTableColumn;

    @FXML
    private TableView<MaintenanceIssue> maintenceIssueTableView;

    @FXML
    private TableColumn<MaintenanceIssue, String> priorityLevelTableColumn;

    @FXML
    private TextField searchKeyWordTextField;

    @FXML
    void assignToMeButton(ActionEvent event) {

    }

    @FXML
    void backToDashboardButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Staff_Main_Dashboard.fxml"));
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
    void filterButton(ActionEvent event) {

    }

}
