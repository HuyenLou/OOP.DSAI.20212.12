package controllers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpScreenController {
	
    @FXML
    private TextArea helpText;
    private String line;


    @FXML
    private void initialize() {
        try {
            File file = new File("sourcecode/controllers/helptext.txt");
            FileInputStream ft = new FileInputStream(file);
            DataInputStream in = new DataInputStream(ft);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            while ((line = br.readLine()) != null) {
                helpText.appendText(line);
                helpText.appendText("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    public void showScreen() throws Exception {
        Stage helpStage = new Stage();
        final String FXML_FILE_PATH = "/HelpScreen.fxml/";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_FILE_PATH));
        HelpScreenController helpScreenController = new HelpScreenController();
        fxmlLoader.setController(helpScreenController);
        Parent root = fxmlLoader.load();
		
        helpStage.initModality(Modality.APPLICATION_MODAL);
		 
        helpStage.setTitle("Help");
        helpStage.setScene(new Scene(root));
        helpStage.show();
		
		
    }

}
