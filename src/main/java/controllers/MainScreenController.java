package controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import sound.PianoPlayer;
import sound.Player;

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

    private Map<Character, Button> buttonMap = new HashMap<>();
    private Set<Character> inUse = new HashSet<>();
    private Player player = new PianoPlayer();

    @FXML
    private void initialize() {
        buttonMap.put('q', C1);
        buttonMap.put('w', D1);
        buttonMap.put('e', E1);
        buttonMap.put('r', F1);
        buttonMap.put('t', G1);
        buttonMap.put('y', A1);
        buttonMap.put('u', B1);

        buttonMap.put('a', C2);
        buttonMap.put('s', D2);
        buttonMap.put('d', E2);
        buttonMap.put('f', F2);
        buttonMap.put('g', G2);
        buttonMap.put('h', A2);
        buttonMap.put('j', B2);

        buttonMap.put('z', C3);
        buttonMap.put('x', D3);
        buttonMap.put('c', E3);
        buttonMap.put('v', F3);
        buttonMap.put('b', G3);
        buttonMap.put('n', A3);
        buttonMap.put('m', B3);
        
        C1.setOnMousePressed(e -> {
            player.playNote("C1");
        });
        D1.setOnMousePressed(e -> {
            player.playNote("D1");
        });
        E1.setOnMousePressed(e -> {
            player.playNote("E1");
        });
        F1.setOnMousePressed(e -> {
            player.playNote("F1");
        });
        G1.setOnMousePressed(e -> {
            player.playNote("G1");
        });
        A1.setOnMousePressed(e -> {
            player.playNote("A1");
        });
        B1.setOnMousePressed(e -> {
            player.playNote("B1");
        });
        
        C2.setOnMousePressed(e -> {
            player.playNote("C2");
        });
        D2.setOnMousePressed(e -> {
            player.playNote("D2");
        });
        E2.setOnMousePressed(e -> {
            player.playNote("E2");
        });
        F2.setOnMousePressed(e -> {
            player.playNote("F2");
        });
        G2.setOnMousePressed(e -> {
            player.playNote("G2");
        });
        A2.setOnMousePressed(e -> {
            player.playNote("A2");
        });
        B2.setOnMousePressed(e -> {
            player.playNote("B2");
        });
        
        C3.setOnMousePressed(e -> {
            player.playNote("C3");
        });
        D3.setOnMousePressed(e -> {
            player.playNote("D3");
        });
        E3.setOnMousePressed(e -> {
            player.playNote("E3");
        });
        F3.setOnMousePressed(e -> {
            player.playNote("F3");
        });
        G3.setOnMousePressed(e -> {
            player.playNote("G3");
        });
        A3.setOnMousePressed(e -> {
            player.playNote("A3");
        });
        B3.setOnMousePressed(e -> {
            player.playNote("B3");
        });
    }

    public void closePlayer() {
        player.stop();
    }

    public void pressNote(char c) {
        Button button = buttonMap.get(c);
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

    public void releaseNote(char c) {
        Button button = buttonMap.get(c);
        if (button == null || !inUse.contains(c))
            return;
        inUse.remove(c);
        button.fireEvent(new MouseEvent(MouseEvent.MOUSE_RELEASED, 0, 0, 0, 0,
                                        MouseButton.PRIMARY, 1,
                                        false, false, false,
                                        false, false, false,
                                        false, false, false,
                                        false, null));
    }    
}
