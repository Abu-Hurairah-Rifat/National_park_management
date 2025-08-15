package oop.section6.national_park_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LogInViewController {
    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private PasswordField passwordField;


    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) {

        String CheckName = userNameTextField.getText();
        String CheckPassword = passwordField.getText();

        if (CheckName.equals("Permit Officer")  && CheckPassword.equals("1234")){
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

        else if (CheckName.equals("Maintenance Staff")  && CheckPassword.equals("1234")){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Staff_Main_Dashboard.fxml"));
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

        else if (CheckName.equals("Tourist")  && CheckPassword.equals("1234")){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tourist/tourist_dashboard.fxml"));
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

        else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Fill up your User Name and Password properly.");
            errorAlert.show();
        }


    }

    @FXML
    public void initialize(){


    }
}
