package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DetailViewController {
    public ComboBox cmbSelect;
    public Button btnAddVehicle;
    public Button btnAddDriver;
    public Button btnLogOut;
    public AnchorPane openNewContent;

    public void initialize(){
        cmbSelect.getItems().addAll("In Parking","On Delivery");

        cmbSelect.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {

            if (newValue.equals("On Delivery")){
                URL resource = getClass().getResource("../view/OnDeliveryView.fxml");
                Parent load = null;

                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                openNewContent.getChildren().clear();
                openNewContent.getChildren().add(load);
            }else {
                if (newValue.equals("In Parking")){
                    URL resource = getClass().getResource("../view/ParkVehicleView.fxml");
                    Parent load = null;

                    try {
                        load = FXMLLoader.load(resource);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    openNewContent.getChildren().clear();
                    openNewContent.getChildren().add(load);
                }
            }
        }));
    }

    public void LoadVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vehicle");
        stage.show();
    }

    public void loadDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Driver");
        stage.show();
    }

    public void LoadManagement(ActionEvent actionEvent) {
        Stage stage = (Stage) openNewContent.getScene().getWindow();
        stage.close();
    }
}
