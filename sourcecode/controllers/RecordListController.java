package controllers;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RecordListController {

    @FXML
    private GridPane gridPane;
    
    @FXML 
    private Button backButton;

    @FXML 
    public void back(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainScreens.fxml/"));
        Parent root = loader.load();
        MainScreenController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            controller.pressNote((char)e.getCode().getCode(), e.isShiftDown());
            e.consume();
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            controller.releaseNote((char)e.getCode().getCode(), e.isShiftDown());
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
    @FXML
    public void initialize() {
    	final String ITEM_FXML_FILE_PATH="/Item.fxml/";
    	int column = 0;
    	int row=1;
    	 String[] pathnames;
    	 File f = new File("/OOP.DSAI.20212.12/resources/audio");

         // Populates the array with names of files and directories
         pathnames = f.list();
    	for (String pathname : pathnames) {
    		try {
    			FXMLLoader fxmlLoader = new FXMLLoader();
    			fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
    			
    			ItemController itemController=new ItemController(pathname);
    			fxmlLoader.setController(itemController);
    			
    			AnchorPane anchorPane = new AnchorPane();
    			anchorPane= fxmlLoader.load();
    			itemController.setData(pathname);
    			if ( column ==3 ) {
    				column=0;
    				row++;
    			}
    		
    		gridPane.add(anchorPane, column++, row);
    		GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
    		}	catch(IOException e) {e.printStackTrace();	}
    		
    		
    	}

    }
    public void showScreen() throws Exception{
        Stage RecordStage = new Stage();
        final String CART_FXML_FILE_PATH= "/RecordList.fxml/";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        fxmlLoader.setController(new RecordListController());
        Parent root = fxmlLoader.load();

        RecordStage.initModality(Modality.APPLICATION_MODAL);

        RecordStage.setTitle("Record List Screen");
        RecordStage.setScene(new Scene(root));
        RecordStage.show();
    }
}