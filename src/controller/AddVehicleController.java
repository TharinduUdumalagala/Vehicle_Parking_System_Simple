package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Bus;
import model.Lorry;
import model.Van;
import model.Vehicle;

import java.util.ArrayList;

public class AddVehicleController {
    public TextField txtVehicleNumber;
    public TextField txtWeight;
    public TextField txtPassengers;
    public ComboBox cmbVehicleType;
    public Button btnVehicle;

    static ArrayList<Vehicle>vehicleArrayList = new ArrayList<>();
    public TableView tblVehicle;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colWeight;
    public TableColumn colPassengers;

    public void initialize(){

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));

        cmbVehicleType.getItems().addAll("Van","Bus","Lorry");
    }


    public void AddVehicle(ActionEvent actionEvent) {
        if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Van")){
            Van van = new Van(
                    txtVehicleNumber.getText(),
                    cmbVehicleType.getValue().toString(),
                    txtWeight.getText(),
                    Integer.parseInt(txtPassengers.getText())
                    );
            txtVehicleNumber.clear();
            txtWeight.clear();
            txtPassengers.clear();
            if (vehicleArrayList.add(van)){
                loadAllVehicles();
                cmbVehicleType.getSelectionModel().clearSelection();
                new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully..",ButtonType.CLOSE).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again...",ButtonType.CLOSE).show();
            }
        }

        if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Bus")){
            Bus bus = new Bus(
                    txtVehicleNumber.getText(),
                    cmbVehicleType.getValue().toString(),
                    txtWeight.getText(),
                    Integer.parseInt(txtPassengers.getText())
            );
            txtVehicleNumber.clear();
            txtWeight.clear();
            txtPassengers.clear();
            if (vehicleArrayList.add(bus)){
                loadAllVehicles();
                cmbVehicleType.getSelectionModel().clearSelection();
                new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully..",ButtonType.CLOSE).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again...",ButtonType.CLOSE).show();
            }
        }

        if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Lorry")){
            Lorry lorry = new Lorry(
                    txtVehicleNumber.getText(),
                    cmbVehicleType.getValue().toString(),
                    txtWeight.getText(),
                    Integer.parseInt(txtPassengers.getText())
            );
            txtVehicleNumber.clear();
            txtWeight.clear();
            txtPassengers.clear();
            if (vehicleArrayList.add(lorry)){
                loadAllVehicles();
                cmbVehicleType.getSelectionModel().clearSelection();
                new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully..",ButtonType.CLOSE).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again...",ButtonType.CLOSE).show();
            }
        }
    }

    private void loadAllVehicles() {
        ObservableList<Vehicle>observableList= FXCollections.observableArrayList();

        if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Van")){
            for (Vehicle v : vehicleArrayList){
                observableList.add(new Lorry(v.getVehicleNo(),v.getVehicleType(),v.getMaxWeight(),v.getNoOfPassengers()));
            }
            tblVehicle.setItems(observableList);
        }

        if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Bus")){
            for (Vehicle v1 : vehicleArrayList){
                observableList.add(new Lorry(v1.getVehicleNo(),v1.getVehicleType(),v1.getMaxWeight(),v1.getNoOfPassengers()));
            }
            tblVehicle.setItems(observableList);
        }

        if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Lorry")){
            for (Vehicle v2 : vehicleArrayList){
                observableList.add(new Lorry(v2.getVehicleNo(),v2.getVehicleType(),v2.getMaxWeight(),v2.getNoOfPassengers()));
            }
            tblVehicle.setItems(observableList);
        }
    }
}
