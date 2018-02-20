package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;
import service.factory.ServiceFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class WelcomeController implements Initializable {
    @FXML
    private Text txtWelcome;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnSign;
    @FXML
    private Button btnRegister;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnRegister.setOnAction(event -> {
            try {
                regisration();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnSign.setOnAction((ActionEvent event) -> {
            User incomingUser = new User(txtLogin.getText(), txtPassword.getText());
            checkRegistration(incomingUser);
        });
    }

    private void checkRegistration(User user) {
        System.out.println(user);
        try {
            if (ServiceFactory.getServiceMethods().checkRegistration(user)) {
                final FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/chat.fxml"));
                Parent parent = fxmlLoader.load();
                final Stage stage = new Stage();
                Scene value = new Scene(parent);
                stage.setScene(value);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.show();
                txtLogin.clear();
                txtPassword.clear();
            } else {
                txtWelcome.setText("User does not exist. Press register and go on.");
            }
        } catch (NullPointerException e) {
            txtWelcome.setText("User does not exist. Press register and go on.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void regisration() throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/registration.fxml"));
        Parent parent = fxmlLoader.load();
        final Stage stage = new Stage();
        Scene value = new Scene(parent);
        stage.setScene(value);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}
