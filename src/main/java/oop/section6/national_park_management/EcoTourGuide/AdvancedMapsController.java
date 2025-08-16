package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdvancedMapsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox alertsCheckBox;

    @FXML
    private Button downloadMapButton;

    @FXML
    private ImageView mapImageView;

    @FXML
    private CheckBox rangerPostsCheckBox;

    @FXML
    private Button recenterButton;

    @FXML
    private CheckBox restrictedZonesCheckBox;

    @FXML
    private CheckBox waterSourcesCheckBox;

    @FXML
    void initialize() {
        loadDefaultMap();
        setupActionHandlers();
    }

    private void loadDefaultMap() {
    }

    private void setupActionHandlers() {
        rangerPostsCheckBox.setOnAction(this::handleLayerToggle);
        waterSourcesCheckBox.setOnAction(this::handleLayerToggle);
        restrictedZonesCheckBox.setOnAction(this::handleLayerToggle);
        alertsCheckBox.setOnAction(this::handleLayerToggle);

        recenterButton.setOnAction(event -> System.out.println("Action: Recenter map on current GPS location."));
        downloadMapButton.setOnAction(event -> System.out.println("Action: Initiating download of map for offline use..."));
    }

    private void handleLayerToggle(ActionEvent event) {
        CheckBox source = (CheckBox) event.getSource();
        System.out.println("Layer Toggled: " + source.getText() + " | New Status: " + (source.isSelected() ? "ON" : "OFF"));
    }
}