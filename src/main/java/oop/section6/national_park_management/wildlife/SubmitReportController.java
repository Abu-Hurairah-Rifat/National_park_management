package oop.section6.national_park_management.wildlife;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SubmitReportController {
    @javafx.fxml.FXML
    private TextArea contentArea;
    @javafx.fxml.FXML
    private TextField titleField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WildlifeResearcher/Researcher_Submit_Report.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void submitReport(ActionEvent actionEvent) {
        // Create and show information alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Report Submission");
        alert.setHeaderText("Report Submitted Successfully");
        alert.setContentText("Your report titled '" + titleField.getText() + "' has been submitted.");

        alert.showAndWait();

        titleField.clear();
        contentArea.clear();
    }
}