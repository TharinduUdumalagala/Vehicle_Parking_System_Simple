package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import model.Vehicle;
import view.tm.InParkingTm;
import view.tm.OnDeliveryTm;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static controller.AddDriverController.driverArrayList;
import static controller.AddVehicleController.vehicleArrayList;
import static controller.OnDeliveryViewController.onDeliveryVehiclesTMObservableList;
import static controller.ParkVehicleViewController.parkedVehiclesTMObservableList;

public class MainViewController {
    public ComboBox cmbSelectVehicle;
    public Button btnManagementLogIn;
    public ComboBox cmbDriver;
    public Button btnParkVehicle;
    public TextField txtDateTime;
    public Button btnOnDeliveryShift;
    public TextField txtCount;
    public TextField txtVehicleType;
    public TextField txtDate;
    public AnchorPane mainView;

    private int minute;
    private int hour;
    public int second;

    public void initialize(){
        for (Vehicle temp : vehicleArrayList){
            cmbSelectVehicle.getItems().add(temp.getVehicleNo());
        }

        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            cmbSelectVehicle.setAccessibleText((String) newValue);
            for (Vehicle temp : vehicleArrayList){
               if (newValue.equals(temp.getVehicleNo())){
                   txtVehicleType.setText(temp.getVehicleType());
                   disableAndEnable(cmbSelectVehicle.getValue().toString());
                   if (!btnParkVehicle.isDisable()){
                       try {
                           txtCount.setText(temp.park(
                                   temp.getVehicleNo(),
                                   temp.getVehicleType()) + "");
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        }));

        for (Driver d : driverArrayList){
            cmbDriver.getItems().add(d.getName());
        }

        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    second = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                    hour = cal.get(Calendar.HOUR_OF_DAY);

                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        txtDateTime. setText("    " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + " " + state);

                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }catch (NullPointerException e){
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        txtDate.setText(dateFormat.format(date));
    }

    private void disableAndEnable(String vehicleNo) {
        btnParkVehicle.setDisable(false);
        btnOnDeliveryShift.setDisable(false);
        for (InParkingTm temp:parkedVehiclesTMObservableList){
            if (temp.getVehicleNumber().equals(vehicleNo)){
                btnParkVehicle.setDisable(true);
            }
        }
        if (!btnParkVehicle.isDisable()){
            btnOnDeliveryShift.setDisable(true);
        }
    }


    public void goToDilivery(ActionEvent actionEvent) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            parkedVehiclesTMObservableList.removeIf(temp -> temp.getVehicleNumber().equals(cmbSelectVehicle.getValue().toString()));
            OnDeliveryTm onDeliveryTm = new OnDeliveryTm(
                    cmbSelectVehicle.getValue().toString(),
                    txtVehicleType.getText(),
                    cmbDriver.getValue().toString(),
                    java.time.LocalDateTime.now().format(dateTimeFormatter));
            onDeliveryVehiclesTMObservableList.add(onDeliveryTm);
        }catch (NullPointerException e){

        }
    }

    public void goToPark(ActionEvent actionEvent) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            InParkingTm parkingTm = new InParkingTm(
                    cmbSelectVehicle.getValue().toString(),
                    txtVehicleType.getText(),
                    Integer.parseInt(txtCount.getText()),
                    java.time.LocalDateTime.now().format(dateTimeFormatter));
            parkedVehiclesTMObservableList.add(parkingTm);
        }catch (NullPointerException e){

        }
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

    public void RefreshPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainView.fxml");
        Parent load = FXMLLoader.load(resource);
        mainView.getChildren().clear();
        mainView.getChildren().add(load);
    }
}
