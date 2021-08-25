package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.InParkingTm;

public class ParkVehicleViewController {
    public TableView tblParkVehicle;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public TableColumn colVehicleType;
    public TableColumn colVehicleNumber;

    public static ObservableList<InParkingTm> parkedVehiclesTMObservableList = FXCollections.observableArrayList();

    public void initialize(){
        tblParkVehicle.setItems(parkedVehiclesTMObservableList);
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
    }
}
