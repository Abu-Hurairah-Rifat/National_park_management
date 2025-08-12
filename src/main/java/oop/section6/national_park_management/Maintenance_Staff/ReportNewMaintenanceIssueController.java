package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class ReportNewMaintenanceIssueController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<?, ?> issueDescriptionTableColumn;

    @FXML
    private TableColumn<?, ?> issueIdTableColumn;

    @FXML
    private ComboBox<?> issueTypeCombobox;

    @FXML
    private TableColumn<?, ?> issueTypeTableColumn;

    @FXML
    private TableColumn<?, ?> locationTableColumn;

    @FXML
    private TextField locationTextField;

    @FXML
    private TableView<?> maintenceIssueTableView;

    @FXML
    private ComboBox<?> priorityLevelCombobox;

    @FXML
    private TableColumn<?, ?> priorityLevelTableColumn;

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
    void submitIssueButton(ActionEvent event) {

    }

}
