package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import service.factory.ServiceFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class ChatController implements Initializable {


    private static User superUser = ServiceFactory.getServiceMethods().getUserById(0);
    private static User general = ServiceFactory.getServiceMethods().getUserById(2);

    private static User currentUser = general;
    @FXML
    private Text txtTop;
    @FXML
    private TextField txtMessage;
    @FXML
    private TableView <User> tableChat;
    @FXML
    private TableColumn columnId;
    @FXML
    private TableColumn columnUser;
    @FXML
    private Button btnSend;
    @FXML
    private TextArea txtChat;
    @FXML
    private Button btnBack;

    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        btnSend.setOnAction(event -> send());
        btnBack.setOnAction(event -> goBack());
    }

    private void goBack() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    private void send() {
        String message = txtMessage.getText();
        currentUser = tableChat.getSelectionModel().getSelectedItem();
        ServiceFactory.getServiceMethods().writeMessageToDB(message, superUser, currentUser);
        txtMessage.clear();
        loadChat();
    }

    private void init() {
        loadChat();
        List<User> users = ServiceFactory.getServiceMethods().getAllUsers();
        users.remove(0);
        userList.clear();
        userList.addAll(users);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableChat.setItems(userList);

    }

    private void loadChat() {
        txtChat.setText(ServiceFactory.getServiceMethods().getAllMessages(superUser, currentUser));
    }
}
