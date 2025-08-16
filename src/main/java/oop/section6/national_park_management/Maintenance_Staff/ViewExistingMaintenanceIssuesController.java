package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import oop.section6.national_park_management.Permit_Officer.IssuePermit;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ViewExistingMaintenanceIssuesController {

    @FXML
    private TableColumn<MaintenanceIssue, String> issueDescriptionTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueIdTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueTypeTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> locationTableColumn;

    @FXML
    private TableView<MaintenanceIssue> maintenceIssueTableView;

    @FXML
    private TableColumn<MaintenanceIssue, String> priorityLevelTableColumn;

    ArrayList maintenanceIssueList = new ArrayList<String>();
    @FXML
    private ComboBox issueTypeComboBox;

    @FXML
    void backToDashBoardButton(ActionEvent event) {
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
        ArrayList<MaintenanceIssue> filterIssueList = new ArrayList<MaintenanceIssue>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File a = new File("IssueInfo.bin");
            if (a.exists()){
                fis = new FileInputStream(a);
            }
            else{
                //Alert: File does not exist
            }
            if (fis!= null){
                ois = new ObjectInputStream(fis);
            }
            while (true){
                maintenceIssueTableView.getItems().add((MaintenanceIssue) ois.readObject());

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

        try{
            for (MaintenanceIssue m: filterIssueList){
                if (m.getIssueType().equals(issueTypeComboBox.getValue())){
                    maintenceIssueTableView.getItems().add((MaintenanceIssue)ois.readObject());
                }
            }

        } catch (Exception e) {
            //
        }


    }

    @FXML
    public void viewAllIssueButton(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File a = new File("IssueInfo.bin");
            if (a.exists()){
                fis = new FileInputStream(a);
            }
            else{
                //Alert: File does not exist
            }
            if (fis!= null){
                ois = new ObjectInputStream(fis);
            }
            while (true){
                maintenceIssueTableView.getItems().add((MaintenanceIssue) ois.readObject());

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
        maintenanceIssueList = new ArrayList<>();

        issueTypeComboBox.getItems().addAll("Trail Damage", "Facility Breakdown", "Waste Management", "Equipment Malfunction");

        issueIdTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("issueID"));
        issueTypeTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("issueType"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("location"));
        issueDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("details"));
        priorityLevelTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("priorityLevel"));
    }
}
