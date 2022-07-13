package controllers;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
	private String pathname;

	public ItemController(String pathname) {
		this.pathname=pathname;
	}

	
	public void setData(String pathname) {
		lblTitle.setText(pathname);
		btnPlay.setVisible(true);
		
			
		}


    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;


    



    @FXML
    void btnPlayClicked(ActionEvent event) {
    	 File sound = new File("/OOP.DSAI.20212.12/resources/audio/"+pathname);

	        try {
	            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
	            Clip c = AudioSystem.getClip();
	            c.open(ais); 
	            System.out.println("Playing");
	            c.start(); 

	            Thread.sleep((int)(c.getMicrosecondLength() * 0.001));
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

		  }
    }
