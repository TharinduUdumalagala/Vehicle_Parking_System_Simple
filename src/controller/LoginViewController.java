package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginViewController {
    public TextField txtUserName;
    public PasswordField pwdPassword;
    public Button btnLogIn;
    public Button btnCancel;
    public AnchorPane manageViewContext;

    public void onLogin(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("") & pwdPassword.getText().equals("")){
            URL resource = getClass().getResource("../view/DetailView.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) manageViewContext.getScene().getWindow();
            window.setTitle("Dashboard");
            window.setScene(new Scene(load));

        }
    }

    public void onCancel(ActionEvent actionEvent) {
        txtUserName.clear();
        pwdPassword.clear();
        Stage stage = (Stage) manageViewContext.getScene().getWindow();
        stage.close();
    }
}
