package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.InParkingTm;
import view.tm.OnDeliveryTm;

public class OnDeliveryViewController {
    public TableView tblOnDelivery;
    public TableColumn colLeftTime;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;

    public static ObservableList<OnDeliveryTm> onDeliveryVehiclesTMObservableList = FXCollections.observableArrayList();


    public void initialize(){
        tblOnDelivery.setItems(onDeliveryVehiclesTMObservableList);
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));
    }
}
