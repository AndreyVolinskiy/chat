package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.User;
import service.factory.ServiceFactory;

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
        User user = new User(txtLogin.getText(), txtPassword.getText());
        btnRegister.setOnAction(event -> regisration());
        btnSign.setOnAction(event -> checkRegistration(user));
    }

    private void checkRegistration(User user) {
        if (ServiceFactory.getServiceMethods().checkRegistration(user)) {

//todo go to next view_chat
            ;
        } else {
            txtWelcome.setText("User does not exist. Press register and go on.");
        }

    }

    private void regisration() {

    }
}
