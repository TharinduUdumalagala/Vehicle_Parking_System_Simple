package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;

import static controller.AddVehicleController.vehicleArrayList;

public class MainViewController {
    public ComboBox cmbSelectVehicle;
    public Button btnManagementLogIn;
    public ComboBox cmbVehicleType;
    public ComboBox cmbDriver;
    public Button btnParkVehicle;
    public TextField txtDateTime;
    public Button btnOnDeliveryShift;
    public TextField txtCount;

    public void initialize(){
        for (Vehicle temp : vehicleArrayList){
            cmbSelectVehicle.getItems().add(temp.getVehicleNo());
        }
    }


    public void goToDilivery(ActionEvent actionEvent) {

    }

    public void goToPark(ActionEvent actionEvent) {

    }

    public void LoadManagement(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginView.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
}
