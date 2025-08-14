package oop.section6.national_park_management.Permit_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class PermitOfficerIssueNewPermitController {

    @FXML
    private TableColumn<IssuePermit, String> emailTableColumn;

    @FXML
    private TextField visitorNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField noOfVisitorsTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TableColumn<IssuePermit, String> noOfVisitorsTableColumn;

    @FXML
    private TableView<IssuePermit> permitDataTableView;

    @FXML
    private TableColumn<IssuePermit, String> permitIdTableColumn;

    @FXML
    private ComboBox<String> permitTypeComboBox;

    @FXML
    private TableColumn<IssuePermit, String> permitTypeTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> phoneTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> totalFeeTableColumn;

    @FXML
    private DatePicker visitDateDatePicker;

    @FXML
    private TableColumn<IssuePermit, String> visitDateTableColumn;

    @FXML
    private TableColumn<IssuePermit, String> visitorNameTableColumn;


    ArrayList<IssuePermit> IssuePermitList;

    @FXML
    void issuePermitButton(ActionEvent event) {
        boolean digitFound = false;
        for(int i=0; i<visitorNameTextField.getText().length(); i++){
            if(visitorNameTextField.getText().charAt(i) >= '0' && visitorNameTextField.getText().charAt(i) <= '9')
                digitFound=true;
        }

        boolean digitFound2 = false;
        for(int j=0; j<emailTextField.getText().length(); j++){
            if(emailTextField.getText().charAt(j) >= '0' && emailTextField.getText().charAt(j) <= '9')
                digitFound2=true;
        }

        if (visitorNameTextField.getText().isEmpty() ||
                emailTextField.getText().isEmpty() ||
                phoneTextField.getText().isEmpty() ||
                noOfVisitorsTextField.getText().isEmpty() ||
                visitDateDatePicker.getValue().isBefore(LocalDate.now()) ||
                digitFound || digitFound2  ){

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Fill up the form properly.");
            errorAlert.show();
        }

        else{
            Alert processCompleteAlert = new Alert(Alert.AlertType.INFORMATION);
            processCompleteAlert.setContentText("Permit information submitted properly");
            processCompleteAlert.show();
            IssuePermit issuePermitToBeAdded = new IssuePermit(
                    visitorNameTextField.getText(),
                    emailTextField.getText(),
                    Integer.parseInt(phoneTextField.getText()),
                    permitTypeComboBox.getValue(),
                    Integer.parseInt(noOfVisitorsTextField.getText()),
                    visitDateDatePicker.getValue()
            );

            permitDataTableView.getItems().add(issuePermitToBeAdded);
            IssuePermitList.add(issuePermitToBeAdded);

            try{
                File f = new File("PermitInfo.bin");
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;

                if (f.exists()){
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }



                for (IssuePermit p : IssuePermitList){
                    oos.writeObject(p);
                }
                oos.close();

            }
            catch (Exception e) {
                //
            }
        }

    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/Permit_Officer_Main_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }
    @FXML
    void initialize(){
        IssuePermitList = new ArrayList<>();
        visitDateDatePicker.setValue(LocalDate.now());
        permitTypeComboBox.getItems().addAll("Day Pass", "Multi-Day Pass", "Research Permit");

        permitIdTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("id"));
        visitorNameTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("name"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("email"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("phone"));
        permitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("permitType"));
        noOfVisitorsTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("noOfVisitor"));
        visitDateTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("visitDate"));
        totalFeeTableColumn.setCellValueFactory(new PropertyValueFactory<IssuePermit, String>("price"));

    }
}
