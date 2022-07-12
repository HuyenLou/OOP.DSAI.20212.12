package controllers;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class RecordListController {

    @FXML
    private GridPane gridPane;
    @FXML
    public void initialize() {
    	final String ITEM_FXML_FILE_PATH="/screens/Item.fxml";
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
}