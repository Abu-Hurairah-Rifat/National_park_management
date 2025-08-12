package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

public class MaintenanceWorkLogsController {

    @FXML
    private TableColumn<?, ?> detailsOfWorkPerformedTableColumn;

    @FXML
    private TextArea detailsOfWorkPerformedTextArea;

    @FXML
    private DatePicker endDateDatepicker;

    @FXML
    private TableColumn<?, ?> endTimeTableColumn;

    @FXML
    private TableColumn<?, ?> issueIdTableColumn;

    @FXML
    private TextField issueIdTextField;

    @FXML
    private TableView<?> recordWorkLogTableView;

    @FXML
    private DatePicker startDateDatepicker;

    @FXML
    private TableColumn<?, ?> startTimeTableColumn;

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
    void saveLogButton(ActionEvent event) {

    }

}
