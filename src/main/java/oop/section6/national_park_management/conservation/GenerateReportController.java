package oop.section6.national_park_management.conservation;

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

public class GenerateReportController {
    @javafx.fxml.FXML
    private TextArea contentArea;
    @javafx.fxml.FXML
    private TextField titleField;
    @javafx.fxml.FXML
    private TextArea referencesArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ConservatinDataAnalyst/Analyst_Generate_Report.fxml"));
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

    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) {
        // Create and show information alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Report Status");
        alert.setHeaderText("Report Generation Complete");
        alert.setContentText("The report '" + titleField.getText() + "' has been successfully generated.");

        alert.showAndWait();

        // Optional: Clear the form after submission
        titleField.clear();
        contentArea.clear();
        referencesArea.clear();
    }
}