package controllers;

import java.io.IOException;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import sound.PianoPlayer;
import sound.GuitarPlayer;
import sound.OrganPlayer;
import sound.Player;
import sound.Recorder;

public class MainScreenController {
    @FXML
    private Button C1;
    @FXML
    private Button Db1;
    @FXML
    private Button D1;
    @FXML
    private Button Eb1;
    @FXML
    private Button E1;
    @FXML
    private Button F1;
    @FXML
    private Button Gb1;
    @FXML
    private Button G1;
    @FXML
    private Button Ab1;
    @FXML
    private Button A1;
    @FXML
    private Button Bb1;
    @FXML
    private Button B1;
    @FXML
    private Button C2;
    @FXML
    private Button Db2;
    @FXML
    private Button D2;
    @FXML
    private Button Eb2;
    @FXML
    private Button E2;
    @FXML
    private Button F2;
    @FXML
    private Button Gb2;
    @FXML
    private Button G2;
    @FXML
    private Button Ab2;
    @FXML
    private Button A2;
    @FXML
    private Button Bb2;
    @FXML
    private Button B2;
    @FXML
    private Button C3;
    @FXML
    private Button Db3;
    @FXML
    private Button D3;
    @FXML
    private Button Eb3;
    @FXML
    private Button E3;
    @FXML
    private Button F3;
    @FXML
    private Button Gb3;
    @FXML
    private Button G3;
    @FXML
    private Button Ab3;
    @FXML
    private Button A3;
    @FXML
    private Button Bb3;
    @FXML
    private Button B3;
    @FXML
    private Button C4;
    @FXML
    private Button Db4;
    @FXML
    private Button D4;
    @FXML
    private Button Eb4;
    @FXML
    private Button E4;
    @FXML
    private Button F4;
    @FXML
    private Button Gb4;
    @FXML
    private Button G4;
    @FXML
    private Button Ab4;
    @FXML
    private Button A4;
    @FXML
    private Button Bb4;
    @FXML
    private Button B4;

    @FXML
    private Button btnVolume;
    @FXML
    private AnchorPane volumePane;
    @FXML
    private Slider volumeSlider;
    @FXML
    private HBox OptionStyles;
    @FXML
    private Button btnStyles;

    private Map<Character, Button> buttonMap = new HashMap<>();
    private Set<Character> inUse = new HashSet<>();
    private Player player = new PianoPlayer();
    final String pressedWhiteNStyle = "-fx-background-color: #c2c2c2; -fx-background-radius: 10;";
    final String releasedWhiteNStyle = "-fx-background-color: white; -fx-background-radius: 10;";
    final String pressedBlackNStyle = "-fx-background-color: #737373; -fx-background-radius: 10;";
    final String releasedBlackNStyle = "-fx-background-color: black; -fx-background-radius: 10;";
    
    @FXML 
    void usePiano(ActionEvent event) {

        player = new PianoPlayer();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("changed to piano style");
        alert.showAndWait();
    }

    @FXML 
    void useGuitar(ActionEvent event) {

        player = new GuitarPlayer();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("changed to guitar style");
        alert.showAndWait();

    } 
    @FXML 
    void useOrgan(ActionEvent event) {

        player = new OrganPlayer();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("changed to organ style");
        alert.showAndWait();
    } 

    @FXML
    private void initialize() {
        setKeyMap();
        for (Button button : buttonMap.values()) {
            if (button.getStyle().contains("white")) {
                button.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
                    button.setStyle(pressedWhiteNStyle);
                });
                button.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> {
                    button.setStyle(releasedWhiteNStyle);
                });
            } else {
                button.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
                    button.setStyle(pressedBlackNStyle);
                });
                button.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> {
                    button.setStyle(releasedBlackNStyle);
                });
            }
        }
        setMouseEvent();

        noti.setVisible(false);
        startRecordButton.setVisible(false);
        finishRecordButton.setVisible(false);
        playRecordButton.setVisible(false);
        showListButton.setVisible(false);
        
        btnVolume.setOnAction(e -> {
            volumePane.setVisible(!volumePane.isVisible());
        });
        volumePane.setVisible(false);
        volumeSlider.valueProperty().addListener((o, oldValue, newValue) -> {
            player.setVolume(newValue.floatValue());
        });
        volumeSlider.setValue(75.0);
        btnStyles.setOnAction(e -> {
            OptionStyles.setVisible(!volumePane.isVisible());
        });
        OptionStyles.setVisible(false);
        btnStyles.setOnAction(e -> {
            OptionStyles.setVisible(!OptionStyles.isVisible());
        });
    }

    @FXML 
    private Button startRecordButton;
    @FXML 
    private Button finishRecordButton;
    @FXML 
    private Button playRecordButton;
     
    @FXML 
    private Button btnClear;
    
    @FXML 
    private TextField notePlayed ;
    
    @FXML  
    void showRecordButton(ActionEvent event) {
    	startRecordButton.setVisible(!startRecordButton.isVisible());
    	finishRecordButton.setVisible(!finishRecordButton.isVisible());
    	playRecordButton.setVisible(!playRecordButton.isVisible());	
    	showListButton.setVisible(!showListButton.isVisible());
    }

    public void hideVolumeController() {
        if (!btnVolume.isFocused() && !volumeSlider.isFocused()) volumePane.setVisible(false);
    }

    public void closePlayer() {
        player.stop();
    }
    
    private String reduceLyric(String song) {
    	if (song.length()<90) {
            return song;
    	}
    	else {
            return song.substring(song.length()-90, song.length());
    	}
    }


    private static final String keyString = "1!2@3#4$5%6^7&8*9(0)-_=+[{]};:,<.>/?";
    private static String getKeyString(char c) {
        if ('A' <= c && c <= 'Z') {
            return String.format("%c%c", c + 32, c);
        }
        int id = keyString.indexOf(c);
        if (id < 0) return null;
        return String.format("%c%c", keyString.charAt(id), keyString.charAt(id + 1));
    }

    public void pressNote(char c, boolean shiftOn) {
        String s = getKeyString(c);
        if (s == null) return;
        Button button;
        if (shiftOn) button = buttonMap.get(s.charAt(1));
        else button = buttonMap.get(s.charAt(0));
        if (button == null || inUse.contains(c))
            return;
        inUse.add(c);
        button.fireEvent(new MouseEvent(MouseEvent.MOUSE_PRESSED, 0, 0, 0, 0,
                                        MouseButton.PRIMARY, 1,
                                        false, false, false,
                                        false, false, false,
                                        false, false, false,
                                        false, null));
    }
    
    private void resetStyle(Button button) {
        if (button == null) return;
        if (button.getStyle().equals(pressedWhiteNStyle)) {
            button.setStyle(releasedWhiteNStyle);
        } else if (button.getStyle().equals(pressedBlackNStyle)) {
            button.setStyle(releasedBlackNStyle);
        }
    }

    public void releaseNote(char c, boolean shiftDown) {
        String s = getKeyString(c);
        if (s == null) return;
        Button button1, button2;
        if (shiftDown) {
            button1 = buttonMap.get(s.charAt(1));
            button2 = buttonMap.get(s.charAt(0));
        } else {
            button1 = buttonMap.get(s.charAt(0));
            button2 = buttonMap.get(s.charAt(1));
        }
        resetStyle(button1);
        resetStyle(button2);
        if (button1 == null || !inUse.contains(c))
            return;
        inUse.remove(c);
        button1.fireEvent(new MouseEvent(MouseEvent.MOUSE_RELEASED, 0, 0, 0, 0,
                                         MouseButton.PRIMARY, 1,
                                         false, false, false,
                                         false, false, false,
                                         false, false, false,
                                         false, null));
    }

    private void setKeyMap() {
        buttonMap.put('1', C1);
        buttonMap.put('@', Db1);
        buttonMap.put('2', D1);
        buttonMap.put('#', Eb1);
        buttonMap.put('3', E1);
        buttonMap.put('4', F1);
        buttonMap.put('%', Gb1);
        buttonMap.put('5', G1);
        buttonMap.put('^', Ab1);
        buttonMap.put('6', A1);
        buttonMap.put('&', Bb1);
        buttonMap.put('7', B1);

        buttonMap.put('y', C2);
        buttonMap.put('U', Db2);
        buttonMap.put('u', D2);
        buttonMap.put('I', Eb2);
        buttonMap.put('i', E2);
        buttonMap.put('o', F2);
        buttonMap.put('P', Gb2);
        buttonMap.put('p', G2);
        buttonMap.put('{', Ab2);
        buttonMap.put('[', A2);
        buttonMap.put('}', Bb2);
        buttonMap.put(']', B2);

        buttonMap.put('a', C3);
        buttonMap.put('S', Db3);
        buttonMap.put('s', D3);
        buttonMap.put('D', Eb3);
        buttonMap.put('d', E3);
        buttonMap.put('f', F3);
        buttonMap.put('G', Gb3);
        buttonMap.put('g', G3);
        buttonMap.put('H', Ab3);
        buttonMap.put('h', A3);
        buttonMap.put('J', Bb3);
        buttonMap.put('j', B3);

        buttonMap.put('v', C4);
        buttonMap.put('B', Db4);
        buttonMap.put('b', D4);
        buttonMap.put('N', Eb4);
        buttonMap.put('n', E4);
        buttonMap.put('m', F4);
        buttonMap.put('<', Gb4);
        buttonMap.put(',', G4);
        buttonMap.put('>', Ab4);
        buttonMap.put('.', A4);
        buttonMap.put('?', Bb4);
        buttonMap.put('/', B4);
    }

    private void setMouseEvent() {
        C1.setOnMousePressed(e -> {
            player.playNote("C1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        C1.setOnMouseReleased(e -> player.stopNote("C1"));
        Db1.setOnMousePressed(e -> {
            player.playNote("Db1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Db1.setOnMouseReleased(e -> player.stopNote("Db1"));
        D1.setOnMousePressed(e -> {
            player.playNote("D1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        D1.setOnMouseReleased(e -> player.stopNote("D1"));
        Eb1.setOnMousePressed(e -> {
            player.playNote("Eb1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Eb1.setOnMouseReleased(e -> player.stopNote("Eb1"));
        E1.setOnMousePressed(e -> {
            player.playNote("E1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        E1.setOnMouseReleased(e -> player.stopNote("E1"));
        F1.setOnMousePressed(e -> {
            player.playNote("F1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        F1.setOnMouseReleased(e -> player.stopNote("F1"));
        Gb1.setOnMousePressed(e -> {
            player.playNote("Gb1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Gb1.setOnMouseReleased(e -> player.stopNote("Gb1"));
        G1.setOnMousePressed(e -> {
            player.playNote("G1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        G1.setOnMouseReleased(e -> player.stopNote("G1"));
        Ab1.setOnMousePressed(e -> {
            player.playNote("Ab1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Ab1.setOnMouseReleased(e -> player.stopNote("Ab1"));
        A1.setOnMousePressed(e -> {
            player.playNote("A1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        A1.setOnMouseReleased(e -> player.stopNote("A1"));
        Bb1.setOnMousePressed(e -> {
            player.playNote("Bb1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Bb1.setOnMouseReleased(e -> player.stopNote("Bb1"));
        B1.setOnMousePressed(e -> {
            player.playNote("B1");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        B1.setOnMouseReleased(e -> player.stopNote("B1"));

        C2.setOnMousePressed(e -> {
            player.playNote("C2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        C2.setOnMouseReleased(e -> player.stopNote("C2"));
        Db2.setOnMousePressed(e -> {
            player.playNote("Db2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Db2.setOnMouseReleased(e -> player.stopNote("Db2"));
        D2.setOnMousePressed(e -> {
            player.playNote("D2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        D2.setOnMouseReleased(e -> player.stopNote("D2"));
        Eb2.setOnMousePressed(e -> {
            player.playNote("Eb2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Eb2.setOnMouseReleased(e -> player.stopNote("Eb2"));
        E2.setOnMousePressed(e -> {
            player.playNote("E2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        E2.setOnMouseReleased(e -> player.stopNote("E2"));
        F2.setOnMousePressed(e -> {
            player.playNote("F2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        F2.setOnMouseReleased(e -> player.stopNote("F2"));
        Gb2.setOnMousePressed(e -> {
            player.playNote("Gb2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Gb2.setOnMouseReleased(e -> player.stopNote("Gb2"));
        G2.setOnMousePressed(e -> {
            player.playNote("G2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        G2.setOnMouseReleased(e -> player.stopNote("G2"));
        Ab2.setOnMousePressed(e -> {
            player.playNote("Ab2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Ab2.setOnMouseReleased(e -> player.stopNote("Ab2"));
        A2.setOnMousePressed(e -> {
            player.playNote("A2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        A2.setOnMouseReleased(e -> player.stopNote("A2"));
        Bb2.setOnMousePressed(e -> {
            player.playNote("Bb2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Bb2.setOnMouseReleased(e -> player.stopNote("Bb2"));
        B2.setOnMousePressed(e -> {
            player.playNote("B2");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        B2.setOnMouseReleased(e -> player.stopNote("B2"));

        C3.setOnMousePressed(e -> {
            player.playNote("C3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        C3.setOnMouseReleased(e -> player.stopNote("C3"));
        Db3.setOnMousePressed(e -> {
            player.playNote("Db3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Db3.setOnMouseReleased(e -> player.stopNote("Db3"));
        D3.setOnMousePressed(e -> {
            player.playNote("D3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        D3.setOnMouseReleased(e -> player.stopNote("D3"));
        Eb3.setOnMousePressed(e -> {
            player.playNote("Eb3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Eb3.setOnMouseReleased(e -> player.stopNote("Eb3"));
        E3.setOnMousePressed(e -> {
            player.playNote("E3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        E3.setOnMouseReleased(e -> player.stopNote("E3"));
        F3.setOnMousePressed(e -> {
            player.playNote("F3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        F3.setOnMouseReleased(e -> player.stopNote("F3"));
        Gb3.setOnMousePressed(e -> {
            player.playNote("Gb3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Gb3.setOnMouseReleased(e -> player.stopNote("Gb3"));
        G3.setOnMousePressed(e -> {
            player.playNote("G3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        G3.setOnMouseReleased(e -> player.stopNote("G3"));
        Ab3.setOnMousePressed(e -> {
            player.playNote("Ab3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Ab3.setOnMouseReleased(e -> player.stopNote("Ab3"));
        A3.setOnMousePressed(e -> {
            player.playNote("A3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        A3.setOnMouseReleased(e -> player.stopNote("A3"));
        Bb3.setOnMousePressed(e -> {
            player.playNote("Bb3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Bb3.setOnMouseReleased(e -> player.stopNote("Bb3"));
        B3.setOnMousePressed(e -> {
            player.playNote("B3");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        B3.setOnMouseReleased(e -> player.stopNote("B3"));

        C4.setOnMousePressed(e -> {
            player.playNote("C4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        C4.setOnMouseReleased(e -> player.stopNote("C4"));
        Db4.setOnMousePressed(e -> {
            player.playNote("Db4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Db4.setOnMouseReleased(e -> player.stopNote("Db4"));
        D4.setOnMousePressed(e -> {
            player.playNote("D4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        D4.setOnMouseReleased(e -> player.stopNote("D4"));
        Eb4.setOnMousePressed(e -> {
            player.playNote("Eb4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Eb4.setOnMouseReleased(e -> player.stopNote("Eb4"));
        E4.setOnMousePressed(e -> {
            player.playNote("E4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        E4.setOnMouseReleased(e -> player.stopNote("E4"));
        F4.setOnMousePressed(e -> {
            player.playNote("F4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        F4.setOnMouseReleased(e -> player.stopNote("F4"));
        Gb4.setOnMousePressed(e -> {
            player.playNote("Gb4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Gb4.setOnMouseReleased(e -> player.stopNote("Gb4"));
        G4.setOnMousePressed(e -> {
            player.playNote("G4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        G4.setOnMouseReleased(e -> player.stopNote("G4"));
        Ab4.setOnMousePressed(e -> {
            player.playNote("Ab4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Ab4.setOnMouseReleased(e -> player.stopNote("Ab4"));
        A4.setOnMousePressed(e -> {
            player.playNote("A4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        A4.setOnMouseReleased(e -> player.stopNote("A4"));
        Bb4.setOnMousePressed(e -> {
            player.playNote("Bb4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        Bb4.setOnMouseReleased(e -> player.stopNote("Bb4"));
        B4.setOnMousePressed(e -> {
            player.playNote("B4");
            notePlayed.setText(reduceLyric(player.getText()));
        });
        B4.setOnMouseReleased(e -> player.stopNote("B4"));
    }
    @FXML
    void btnHelpPressed(ActionEvent event) throws Exception {
    	HelpScreenController helpScreenController = new HelpScreenController();
        helpScreenController.showScreen();
    }
    @FXML
    void btnExitPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit confirmation");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.isEmpty() || option.get() == ButtonType.CANCEL)
            event.consume();
        else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            closePlayer();
            stage.close();
        }
    }
    @FXML
    void btnStylesPressed(ActionEvent event) {
    	OptionStyles.setVisible(true);
    }
    
    Recorder recorder = new Recorder();
    @FXML
    void startRecord(ActionEvent event) {
    	recorder.begin();
    	noti.setVisible(true);
    }

    @FXML
    void finishRecord(ActionEvent event) {
    	recorder.finish();
    	noti.setVisible(false);
    }
    @FXML
    void playRecord(ActionEvent event) {
    	recorder.play();
   }
    
    @FXML 
    void startReplay(ActionEvent event) {	
    	String[] notes = player.getText().strip().split(" ");
    	for(int i=0; i< notes.length; i++){
            player.playNote(notes[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    	}
    }
    @FXML 
    void clearText(ActionEvent event) {
    	notePlayed.setText("");
    	player.setText("");
    }
    @FXML
    private Label noti;
    
    @FXML 
    private Button showListButton;
    
    @FXML 
    void showList(ActionEvent event) throws Exception {
        RecordListController recordListController = new RecordListController();
        recordListController.showScreen();
    }
}
