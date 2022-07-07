package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import controllers.*;

public class App extends Application {
   

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/MainScreens.fxml"));
        Parent root = loader.load();
        MainScreenController controller = loader.getController();
        Scene scene = new Scene(root);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            char c = (char)(32 + e.getCode().getChar().charAt(0));
            if (e.isShiftDown()) {
                c -= 32;
            }
            controller.pressNote(c);
            e.consume();
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            char c = (char)(32 + e.getCode().getChar().charAt(0));
            if (e.isShiftDown()) {
                c -= 32;
            }
            controller.releaseNote(c);
            e.consume();
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
