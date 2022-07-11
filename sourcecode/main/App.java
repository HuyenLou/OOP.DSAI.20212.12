package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.net.URL;

import controllers.*;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainScreens.fxml"));
        Parent root = loader.load();
        MainScreenController controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getText().length() < 1)
                return;
            controller.pressNote(e.getText().charAt(0));
            e.consume();
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            if (e.getText().length() < 1)
                return;
            controller.releaseNote(e.getText().charAt(0));
            e.consume();
        });
        scene.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> {
            controller.hideVolumeController();
        });
        stage.setOnCloseRequest(e -> {
            controller.closePlayer();
        });
        stage.setTitle("Virtual piano");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
