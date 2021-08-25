package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Driver;

import java.util.ArrayList;

public class AddDriverController {
    public TextField txtDriverName;
    public TextField txtNIC;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public Button btnDriver;
    public TextField txtContact;
    public TableView tblDriver;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colLicense;
    public TableColumn colAddress;
    public TableColumn colContact;

    static ArrayList<Driver> driverArrayList = new ArrayList();

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("LicenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    public void AddDriver(ActionEvent actionEvent) {
        Driver driver = new Driver(
                txtDriverName.getText(),
                txtNIC.getText(),
                txtLicenseNo.getText(),
                txtAddress.getText(),
                Integer.parseInt(txtContact.getText())
        );

        txtDriverName.clear();
        txtNIC.clear();
        txtLicenseNo.clear();
        txtAddress.clear();
        txtContact.clear();

        if (driverArrayList.add(driver)){
            loadAllDriver();
            new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully..",ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again...",ButtonType.CLOSE).show();
        }
    }

    private void loadAllDriver() {
        ObservableList<Driver> observableList = FXCollections.observableArrayList();
        for (Driver temp : driverArrayList){
            observableList.add(new Driver(
                    temp.getName(),
                    temp.getNIC(),
                    temp.getLicenseNo(),
                    temp.getAddress(),
                    temp.getContact()
            ));
        }
        tblDriver.setItems(observableList);
    }
}
