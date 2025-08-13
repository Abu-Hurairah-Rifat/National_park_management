package oop.section6.national_park_management.Tourist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PlanItineraryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private ListView<String> attractionsListView;

    @FXML
    private ListView<String> itineraryListView;

    @FXML
    private TextField itineraryNameField;

    @FXML
    private Button loadItineraryButton;

    @FXML
    private ImageView mapImageView;

    @FXML
    private Button moveDownButton;

    @FXML
    private Button moveUpButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button saveItineraryButton;

    @FXML
    private ComboBox<String> savedItinerariesComboBox;

    @FXML
    private Label statusLabel;

    private ObservableList<String> attractions;
    private ObservableList<String> myItinerary;
    private ObservableList<String> savedItineraries;

    @FXML
    void initialize() {
        attractions = FXCollections.observableArrayList(
                "Main Gate & Visitor Center",
                "Waterfall Trail",
                "Gibbon Point",
                "Canopy Walkway",
                "Tea Garden Viewpoint",
                "Orchid Garden",
                "Butterfly Park"
        );
        attractionsListView.setItems(attractions);

        myItinerary = FXCollections.observableArrayList();
        itineraryListView.setItems(myItinerary);

        savedItineraries = FXCollections.observableArrayList("Weekend Trip", "Photographer's Route");
        savedItinerariesComboBox.setItems(savedItineraries);

        addButton.setOnAction(event -> handleAdd());
        removeButton.setOnAction(event -> handleRemove());
        moveUpButton.setOnAction(event -> handleMoveUp());
        moveDownButton.setOnAction(event -> handleMoveDown());
        saveItineraryButton.setOnAction(event -> handleSave());
        loadItineraryButton.setOnAction(event -> handleLoad());
    }

    private void handleAdd() {
        String selectedAttraction = attractionsListView.getSelectionModel().getSelectedItem();
        if (selectedAttraction != null && !myItinerary.contains(selectedAttraction)) {
            myItinerary.add(selectedAttraction);
        }
    }

    private void handleRemove() {
        String selectedItem = itineraryListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            myItinerary.remove(selectedItem);
        }
    }

    private void handleMoveUp() {
        int selectedIndex = itineraryListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            String item = myItinerary.remove(selectedIndex);
            myItinerary.add(selectedIndex - 1, item);
            itineraryListView.getSelectionModel().select(selectedIndex - 1);
        }
    }

    private void handleMoveDown() {
        int selectedIndex = itineraryListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1 && selectedIndex < myItinerary.size() - 1) {
            String item = myItinerary.remove(selectedIndex);
            myItinerary.add(selectedIndex + 1, item);
            itineraryListView.getSelectionModel().select(selectedIndex + 1);
        }
    }

    private void handleSave() {
        String itineraryName = itineraryNameField.getText();
        if (itineraryName == null || itineraryName.trim().isEmpty()) {
            statusLabel.setText("Please enter an itinerary name.");
            return;
        }
        if (myItinerary.isEmpty()) {
            statusLabel.setText("Cannot save an empty itinerary.");
            return;
        }

        if (!savedItineraries.contains(itineraryName)) {
            savedItineraries.add(itineraryName);
        }

        statusLabel.setText("Itinerary '" + itineraryName + "' saved successfully!");
        System.out.println("Saving Itinerary: " + itineraryName);
        System.out.println("Items: " + myItinerary);
    }

    private void handleLoad() {
        String selectedItinerary = savedItinerariesComboBox.getSelectionModel().getSelectedItem();
        if (selectedItinerary != null) {
            myItinerary.clear();
            itineraryNameField.setText(selectedItinerary);
            if (selectedItinerary.equals("Weekend Trip")) {
                myItinerary.addAll("Main Gate & Visitor Center", "Canopy Walkway", "Waterfall Trail");
            } else if (selectedItinerary.equals("Photographer's Route")) {
                myItinerary.addAll("Tea Garden Viewpoint", "Gibbon Point", "Butterfly Park");
            }
            statusLabel.setText("Loaded '" + selectedItinerary + "'.");
        }
    }
}