package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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


	public HelpScreenController() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/screens/helptext.txt"));

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
		final String FXML_FILE_PATH = "/screens/HelpScreen.fxml/";
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
