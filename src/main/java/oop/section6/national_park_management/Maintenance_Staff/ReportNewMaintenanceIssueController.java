package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import oop.section6.national_park_management.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReportNewMaintenanceIssueController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueDescriptionTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueIdTableColumn;

    @FXML
    private ComboBox<String> issueTypeCombobox;

    @FXML
    private TableColumn<MaintenanceIssue, String> issueTypeTableColumn;

    @FXML
    private TableColumn<MaintenanceIssue, String> locationTableColumn;

    @FXML
    private TextField locationTextField;

    @FXML
    private TableView<MaintenanceIssue> maintenceIssueTableView;

    @FXML
    private TableColumn<MaintenanceIssue, String> priorityLevelTableColumn;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton lowRadioButton;
    @FXML
    private RadioButton highRadioButton;
    @FXML
    private RadioButton urgentRadioButton;

    int initialId;

    ArrayList<MaintenanceIssue> maintenanceIssuesList;

    ToggleGroup tg;

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
        if (locationTextField.getText().isEmpty() ||
                descriptionTextArea.getText().isEmpty()
        ){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Fill up the form properly.");
            errorAlert.show();
        }

        else{
            MaintenanceIssue maintenanceIssueToBeAdded = getMaintenanceIssue();

            maintenceIssueTableView.getItems().add(maintenanceIssueToBeAdded);
            maintenanceIssuesList.add(maintenanceIssueToBeAdded);

            try{
                File a = new File("IssueInfo.bin");
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;

                if (a.exists()){
                    fos = new FileOutputStream(a, true);
                    oos = new AppendableObjectOutputStream(fos);
                }
                else{
                    fos = new FileOutputStream(a);
                    oos = new ObjectOutputStream(fos);
                }



                for (MaintenanceIssue m : maintenanceIssuesList){
                    oos.writeObject(m);
                }
                oos.close();

            }
            catch (Exception e) {
                //
            }

        }





    }

    private MaintenanceIssue getMaintenanceIssue() {
        int initialId = 0;

        String priorityLevel = "";
        if (lowRadioButton.isSelected())
            priorityLevel = "Low";
        else if (mediumRadioButton.isSelected())
            priorityLevel = "Medium";
        else if (highRadioButton.isSelected()) {
            priorityLevel = "High";
        }
        else if(urgentRadioButton.isSelected()){
            priorityLevel = "Urgent";
        }

        MaintenanceIssue maintenanceIssueToBeAdded = new MaintenanceIssue(
                initialId,
                issueTypeCombobox.getValue(),
                locationTextField.getText(),
                descriptionTextArea.getText(),
                priorityLevel
        );
        return maintenanceIssueToBeAdded;
    }

    public void initialize(){
        maintenanceIssuesList = new ArrayList<>();
        tg = new ToggleGroup();
        lowRadioButton.setToggleGroup(tg);
        mediumRadioButton.setToggleGroup(tg);
        highRadioButton.setToggleGroup(tg);
        urgentRadioButton.setToggleGroup(tg);

        issueTypeCombobox.getItems().addAll("Trail Damage", "Facility Breakdown", "Waste Management", "Equipment Malfunction");

        issueIdTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("issueID"));
        issueTypeTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("issueType"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("location"));
        issueDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("details"));
        priorityLevelTableColumn.setCellValueFactory(new PropertyValueFactory<MaintenanceIssue, String>("priorityLevel"));

    }

}
