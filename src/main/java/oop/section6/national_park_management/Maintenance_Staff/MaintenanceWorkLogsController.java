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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.AppendableObjectOutputStream;
import oop.section6.national_park_management.HelloApplication;
import oop.section6.national_park_management.Permit_Officer.IssuePermit;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MaintenanceWorkLogsController {

    @FXML
    private TableColumn<WorkLog, String> detailsOfWorkPerformedTableColumn;

    @FXML
    private TextArea detailsOfWorkPerformedTextArea;

    @FXML
    private DatePicker endDateDatepicker;

    @FXML
    private TableColumn<WorkLog, String> endTimeTableColumn;

    @FXML
    private TableColumn<WorkLog, String> issueIdTableColumn;

    @FXML
    private TextField issueIdTextField;

    @FXML
    private TableView<WorkLog> recordWorkLogTableView;

    @FXML
    private DatePicker startDateDatepicker;

    @FXML
    private TableColumn<WorkLog, String> startTimeTableColumn;

    ArrayList<WorkLog> workLogList;

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

        WorkLog workLogToBeAdded = new WorkLog(
                Integer.parseInt(issueIdTextField.getText()),
                startDateDatepicker.getValue(),
                endDateDatepicker.getValue(),
                detailsOfWorkPerformedTextArea.getText());

        recordWorkLogTableView.getItems().add(workLogToBeAdded);
        workLogList.add(workLogToBeAdded);

        try{
            File c = new File("WorkLogInfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            if (c.exists()){
                fos = new FileOutputStream(c, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(c);
                oos = new ObjectOutputStream(fos);
            }



            for (WorkLog w : workLogList){
                oos.writeObject(w);
            }
            oos.close();

        }
        catch (Exception e) {
            //
        }


    }


    @FXML
    public void viewAllButton(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File c = new File("WorkLogInfo.bin");
            if (c.exists()){
                fis = new FileInputStream(c);
            }
            else{
                //Alert: File does not exist
            }
            if (fis!= null){
                ois = new ObjectInputStream(fis);
            }
            while (true){
                recordWorkLogTableView.getItems().add((WorkLog) ois.readObject());

            }

        }

        catch (Exception e) {
            try{
                ois.close();
            }
            catch (Exception ex) {
                //
            }
        }
    }

    public void initialize(){
        workLogList = new ArrayList<>();

        startDateDatepicker.setValue(LocalDate.now());
        endDateDatepicker.setValue(LocalDate.now());

        issueIdTableColumn.setCellValueFactory(new PropertyValueFactory<WorkLog, String>("issueId"));
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<WorkLog, String>("startDate"));
        endTimeTableColumn.setCellValueFactory(new PropertyValueFactory<WorkLog, String>("endDate"));
        detailsOfWorkPerformedTableColumn.setCellValueFactory(new PropertyValueFactory<WorkLog, String>("details"));

    }
}
