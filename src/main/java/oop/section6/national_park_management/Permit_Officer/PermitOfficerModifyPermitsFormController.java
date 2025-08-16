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
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class PermitOfficerModifyPermitsFormController {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField noOfVisitorsTextField;

    @FXML
    private ComboBox<String> permitTypeComboBox;

    @FXML
    private TextField phoneTextField;

    @FXML
    private DatePicker visitDateDatePicker;

    @FXML
    private TextField visitorNameTextField;

    @FXML
    void updatePermitButton(ActionEvent event) {

        Alert updateMessageAlert = new Alert(Alert.AlertType.INFORMATION);
        updateMessageAlert.setContentText("All information are successfully updated.");
        updateMessageAlert.show();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Modify_Permits.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.close();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    public void initialize(){


    }

    @FXML
    public void cancelButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Permit_Officer/permitOfficer_Modify_Permits.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            nextStage.close();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    public void receivePermitName(String name){
        visitorNameTextField.setText(name);
        IssuePermit p = getPermitDataByName(name);
        emailTextField.setText(p.getEmail());
        phoneTextField.setText(Integer.toString(p.getPhone()));
        permitTypeComboBox.getItems().addAll("Day Pass", "Multi-Day Pass", "Research Permit");
        noOfVisitorsTextField.setText(Integer.toString(p.getNoOfVisitor()));
        visitDateDatePicker.setValue(LocalDate.from(p.getVisitDate()));

    }

    public IssuePermit getPermitDataByName(String name){
        ArrayList<IssuePermit> modifyPermitList = new ArrayList<IssuePermit>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("PermitInfo.bin");
            if (f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //Alert: File does not exist
            }
            if (fis!= null){
                ois = new ObjectInputStream(fis);
            }
            while (true){
                modifyPermitList.add((IssuePermit)ois.readObject());

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

        IssuePermit targetPermit = null;
        for (IssuePermit p: modifyPermitList){
            if (p.getName().equals(name)){
                targetPermit = p;
            }
        }
        return targetPermit;

    }
}
