package controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    private Pane volumePane;
    @FXML
    private Slider volumeSlider;

    private Map<Character, Button> buttonMap = new HashMap<>();
    private Set<Character> inUse = new HashSet<>();
    private Player player = new PianoPlayer();

    @FXML
    private void initialize() {
        setKeyMap();
        setMouseEvent();

        btnVolume.setOnAction(e -> {
            volumePane.setVisible(!volumePane.isVisible());
        });
        volumePane.setVisible(false);
        volumeSlider.valueProperty().addListener((o, oldValue, newValue) -> {
            player.setVolume(newValue.floatValue());
        });
        volumeSlider.setValue(75.0);
    }

    public void hideVolumeController() {
        if (!btnVolume.isFocused() && !volumeSlider.isFocused()) volumePane.setVisible(false);
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
        });
        Db1.setOnMousePressed(e -> {
            player.playNote("Db1");
        });
        D1.setOnMousePressed(e -> {
            player.playNote("D1");
        });
        Eb1.setOnMousePressed(e -> {
            player.playNote("Eb1");
        });
        E1.setOnMousePressed(e -> {
            player.playNote("E1");
        });
        F1.setOnMousePressed(e -> {
            player.playNote("F1");
        });
        Gb1.setOnMousePressed(e -> {
            player.playNote("Gb1");
        });
        G1.setOnMousePressed(e -> {
            player.playNote("G1");
        });
        Ab1.setOnMousePressed(e -> {
            player.playNote("Ab1");
        });
        A1.setOnMousePressed(e -> {
            player.playNote("A1");
        });
        Bb1.setOnMousePressed(e -> {
            player.playNote("Bb1");
        });
        B1.setOnMousePressed(e -> {
            player.playNote("B1");
        });
        
        C2.setOnMousePressed(e -> {
            player.playNote("C2");
        });
        Db2.setOnMousePressed(e -> {
            player.playNote("Db2");
        });
        D2.setOnMousePressed(e -> {
            player.playNote("D2");
        });
        Eb2.setOnMousePressed(e -> {
            player.playNote("Eb2");
        });
        E2.setOnMousePressed(e -> {
            player.playNote("E2");
        });
        F2.setOnMousePressed(e -> {
            player.playNote("F2");
        });
        Gb2.setOnMousePressed(e -> {
            player.playNote("Gb2");
        });
        G2.setOnMousePressed(e -> {
            player.playNote("G2");
        });
        Ab2.setOnMousePressed(e -> {
            player.playNote("Ab2");
        });
        A2.setOnMousePressed(e -> {
            player.playNote("A2");
        });
        Bb2.setOnMousePressed(e -> {
            player.playNote("Bb2");
        });
        B2.setOnMousePressed(e -> {
            player.playNote("B2");
        });
        
        C3.setOnMousePressed(e -> {
            player.playNote("C3");
        });
        Db3.setOnMousePressed(e -> {
            player.playNote("Db3");
        });
        D3.setOnMousePressed(e -> {
            player.playNote("D3");
        });
        Eb3.setOnMousePressed(e -> {
            player.playNote("Eb3");
        });
        E3.setOnMousePressed(e -> {
            player.playNote("E3");
        });
        F3.setOnMousePressed(e -> {
            player.playNote("F3");
        });
        Gb3.setOnMousePressed(e -> {
            player.playNote("Gb3");
        });
        G3.setOnMousePressed(e -> {
            player.playNote("G3");
        });
        Ab3.setOnMousePressed(e -> {
            player.playNote("Ab3");
        });
        A3.setOnMousePressed(e -> {
            player.playNote("A3");
        });
        Bb3.setOnMousePressed(e -> {
            player.playNote("Bb3");
        });
        B3.setOnMousePressed(e -> {
            player.playNote("B3");
        });

        C4.setOnMousePressed(e -> {
            player.playNote("C4");
        });
        Db4.setOnMousePressed(e -> {
            player.playNote("Db4");
        });
        D4.setOnMousePressed(e -> {
            player.playNote("D4");
        });
        Eb4.setOnMousePressed(e -> {
            player.playNote("Eb4");
        });
        E4.setOnMousePressed(e -> {
            player.playNote("E4");
        });
        F4.setOnMousePressed(e -> {
            player.playNote("F4");
        });
        Gb4.setOnMousePressed(e -> {
            player.playNote("Gb4");
        });
        G4.setOnMousePressed(e -> {
            player.playNote("G4");
        });
        Ab4.setOnMousePressed(e -> {
            player.playNote("Ab4");
        });
        A4.setOnMousePressed(e -> {
            player.playNote("A4");
        });
        Bb4.setOnMousePressed(e -> {
            player.playNote("Bb4");
        });
        B4.setOnMousePressed(e -> {
            player.playNote("B4");
        });
    }
}
