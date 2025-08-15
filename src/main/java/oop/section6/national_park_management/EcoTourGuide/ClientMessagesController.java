package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ClientMessagesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> chatListView;

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    @FXML
    private ComboBox<String> toursComboBox;

    private Map<String, ObservableList<String>> conversations;

    @FXML
    void initialize() {
        loadSampleConversations();

        toursComboBox.setItems(FXCollections.observableArrayList(conversations.keySet()));

        toursComboBox.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> loadChatHistory(newVal)
        );

        sendButton.setOnAction(this::handleSendMessage);
        messageField.setOnAction(this::handleSendMessage);
    }

    private void loadSampleConversations() {
        conversations = new HashMap<>();

        ObservableList<String> chat1 = FXCollections.observableArrayList(
                "Ayesha Siddiqa: Hi! We're excited for our tour on the 25th. Is there anything special we should bring?"
        );
        conversations.put("Ayesha Siddiqa (Tour on 2025-08-25)", chat1);

        ObservableList<String> chat2 = FXCollections.observableArrayList(
                "Sheikh Nirjhor: Just wanted to confirm our booking for 2 people on September 2nd."
        );
        conversations.put("Sheikh Nirjhor (Tour on 2025-09-02)", chat2);
    }

    private void loadChatHistory(String conversationKey) {
        if (conversationKey != null) {
            chatListView.setItems(conversations.get(conversationKey));
        } else {
            chatListView.setItems(null);
        }
    }

    private void handleSendMessage(ActionEvent event) {
        String message = messageField.getText();
        String conversationKey = toursComboBox.getSelectionModel().getSelectedItem();

        if (message == null || message.trim().isEmpty()) {
            return;
        }

        if (conversationKey == null) {
            return;
        }

        ObservableList<String> currentChat = conversations.get(conversationKey);
        currentChat.add("You: " + message);

        messageField.clear();
        chatListView.scrollTo(currentChat.size() - 1);
    }
}