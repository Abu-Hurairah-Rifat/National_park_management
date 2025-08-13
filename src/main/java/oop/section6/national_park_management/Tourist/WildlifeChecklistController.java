package oop.section6.national_park_management.Tourist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class WildlifeChecklistController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private FlowPane achievementsPane;
    @FXML
    private ProgressBar progress;
    @FXML
    private TextArea speciesDetailsArea;
    @FXML
    private ImageView speciesImageView;
    @FXML
    private ListView<Species> speciesListView;

    private ObservableList<Species> speciesList;

    @FXML
    void initialize() {
        loadSpeciesData();
        setupListView();
        updateProgress();
    }

    private void loadSpeciesData() {
        speciesList = FXCollections.observableArrayList(
                new Species("Hoolock Gibbon", "The only ape found in Bangladesh, known for its distinct calls.", "/oop/section6/national_park_management/Tourist/gibbon.png"),
                new Species("Capped Langur", "A leaf-eating monkey with a distinct dark cap of hair on its head.", "/oop/section6/national_park_management/Tourist/langur.png"),
                new Species("Orange-bellied Himalayan Squirrel", "A large, colorful tree squirrel often seen foraging during the day.", "/oop/section6/national_park_management/Tourist/squirrel.png"),
                new Species("Indian Muntjac (Barking Deer)", "A small deer that makes a bark-like sound when alarmed.", "/oop/section6/national_park_management/Tourist/deer.png"),
                new Species("Red-headed Trogon", "A vibrant, colorful bird typically found in the forest canopy.", "/oop/section6/national_park_management/Tourist/trogon.png")
        );

        speciesList.forEach(species ->
                species.spottedProperty().addListener((obs, oldVal, newVal) -> updateProgress())
        );
    }

    private void setupListView() {
        speciesListView.setItems(speciesList);
        speciesListView.setCellFactory(CheckBoxListCell.forListView(Species::spottedProperty));

        speciesListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> showSpeciesDetails(newSelection)
        );
    }

    private void showSpeciesDetails(Species species) {
        if (species != null) {
            speciesDetailsArea.setText(species.getDescription());
            try {
                Image image = new Image(getClass().getResourceAsStream(species.getImagePath()));
                speciesImageView.setImage(image);
            } catch (Exception e) {
                speciesImageView.setImage(null);
                System.err.println("Failed to load image: " + species.getImagePath());
            }
        } else {
            speciesDetailsArea.clear();
            speciesImageView.setImage(null);
        }
    }

    private void updateProgress() {
        long spottedCount = speciesList.stream().filter(Species::isSpotted).count();
        double progressValue = (double) spottedCount / speciesList.size();
        progress.setProgress(progressValue);

        checkAchievements(spottedCount);
    }

    private void checkAchievements(long spottedCount) {
        if (spottedCount >= 3 && achievementsPane.getChildren().isEmpty()) {
            try {
                ImageView badge = new ImageView(new Image(getClass().getResourceAsStream("/oop/section6/national_park_management/Tourist/badge.png")));
                badge.setFitHeight(80);
                badge.setFitWidth(80);
                achievementsPane.getChildren().add(badge);
                achievementsPane.getChildren().add(new Label("Amateur Biologist"));
            } catch (Exception e) {
                System.err.println("Failed to load badge image.");
            }
        }
    }

    public static class Species {
        private final String name;
        private final String description;
        private final String imagePath;
        private final BooleanProperty spotted;

        public Species(String name, String description, String imagePath) {
            this.name = name;
            this.description = description;
            this.imagePath = imagePath;
            this.spotted = new SimpleBooleanProperty(false);
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
        public String getImagePath() { return imagePath; }
        public boolean isSpotted() { return spotted.get(); }
        public BooleanProperty spottedProperty() { return spotted; }

        @Override
        public String toString() {
            return name;
        }
    }
}