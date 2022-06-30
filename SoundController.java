import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SoundController implements Initializable{
	@FXML
	private MenuItem pianoItem;
	@FXML
	private MenuItem organItem;
	@FXML
	private MenuItem guitarItem;
	@FXML
	private SplitMenuButton splitMenuButton;
	
	@FXML
	void pianoStyle(ActionEvent event) {
		splitMenuButton.setText("Piano");
	}
	
	@FXML
	void organStyle(ActionEvent event) {
		splitMenuButton.setText("Organ");
		
	}
	
	@FXML
	void guitarStyle(ActionEvent event) {
		splitMenuButton.setText("Guitar");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		ImageView pianoIcon = new ImageView(new Image("C:\\Users\\DELL\\JavaLab\\ElectronicPiano\\icons\\piano.png"));
		pianoIcon.setFitHeight(20);
	    pianoIcon.setFitWidth(20);
	    pianoItem.setGraphic(pianoIcon);
	    
	    ImageView organIcon = new ImageView(new Image("C:\\Users\\DELL\\JavaLab\\ElectronicPiano\\icons\\organ.png"));
	    organIcon.setFitHeight(20);
	    organIcon.setFitWidth(20);
	    organItem.setGraphic(organIcon);
	    
	    ImageView guitarIcon = new ImageView(new Image("C:\\Users\\DELL\\JavaLab\\ElectronicPiano\\icons\\guitar.png"));
	    guitarIcon.setFitHeight(20);
	    guitarIcon.setFitWidth(20);
	    guitarItem.setGraphic(guitarIcon);
	}

}
