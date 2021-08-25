import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Initializer extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/MainView.fxml"))));
        primaryStage.setResizable(false);
//        primaryStage.getIcons("assets/icons8-parking-128.png");
        primaryStage.setTitle("Parking System");
        primaryStage.show();
    }
}
