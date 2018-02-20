package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.User;
import service.factory.ServiceFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class RegistrationController implements Initializable {
    @FXML
    private Text txtTop;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPasswordRe;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnBack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnRegister.setOnAction(event -> register());

        btnBack.setOnMouseClicked(event -> {
            try {
                goWelcomeWindow(event);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void register() {
        String name = txtName.getText();
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        String passwordRe = txtPasswordRe.getText();
        User user = new User(name, login, password);
        if (password.equals(passwordRe)) {
            ServiceFactory.getServiceMethods().createNewUser(user);
            txtTop.setText("Registration successful!");
        } else {
            txtTop.setText("Passwords don't match, re-enter");
            txtPassword.clear();
            txtPasswordRe.clear();
        }
    }

    private void goWelcomeWindow(MouseEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/welcome.fxml"));
        Parent parent = fxmlLoader.load();
        final Stage stage = new Stage();
        Scene value = new Scene(parent);
        stage.setScene(value);
        stage.initModality(Modality.WINDOW_MODAL);
        Window window = ((Node) event.getSource()).getScene().getWindow();
        stage.initOwner(window);
        stage.show();
    }
}
