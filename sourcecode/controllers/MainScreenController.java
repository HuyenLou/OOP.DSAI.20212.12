package controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sound.PianoPlayer;
import sound.Player;

public class MainScreenController {
    // @FXML
    // private Button C1;
    // @FXML
    // private Button Db1;
    // @FXML
    // private Button D1;
    // @FXML
    // private Button Eb1;
    // @FXML
    // private Button E1;
    // @FXML
    // private Button F1;
    // @FXML
    // private Button Gb1;
    // @FXML
    // private Button G1;
    // @FXML
    // private Button Ab1;
    // @FXML
    // private Button A1;
    // @FXML
    // private Button Bb1;
    // @FXML
    // private Button B1;
    // @FXML
    // private Button C2;
    // @FXML
    // private Button Db2;
    // @FXML
    // private Button D2;
    // @FXML
    // private Button Eb2;
    // @FXML
    // private Button E2;
    // @FXML
    // private Button F2;
    // @FXML
    // private Button Gb2;
    // @FXML
    // private Button G2;
    // @FXML
    // private Button Ab2;
    // @FXML
    // private Button A2;
    // @FXML
    // private Button Bb2;
    // @FXML
    // private Button B2;
    // @FXML
    // private Button C3;
    // @FXML
    // private Button Db3;
    // @FXML
    // private Button D3;
    // @FXML
    // private Button Eb3;
    // @FXML
    // private Button E3;
    // @FXML
    // private Button F3;
    // @FXML
    // private Button Gb3;
    // @FXML
    // private Button G3;
    // @FXML
    // private Button Ab3;
    // @FXML
    // private Button A3;
    // @FXML
    // private Button Bb3;
    // @FXML
    // private Button B3;

    // private Map<Character, Button> buttonMap = new HashMap<>();
    // private Set<Character> inUse = new HashSet<>();
    // private Player player = new PianoPlayer();

    // @FXML
    // private void initialize() {
    //     background.scaleXProperty().bind(Bindings.createDoubleBinding(() -> {
    //                 return screenPane.getWidth() * 1.2 / 1000;
    //             }, screenPane.widthProperty()));
    //     background.fitHeightProperty().bind(screenPane.heightProperty());
        
    //     setKeyMap();
    //     setMouseEvent();
    // }

    // public void closePlayer() {
    //     player.stop();
    // }

    // public void pressNote(char c) {
    //     Button button = buttonMap.get(c);
    //     if (button == null || inUse.contains(c))
    //         return;
    //     inUse.add(c);
    //     button.fireEvent(new MouseEvent(MouseEvent.MOUSE_PRESSED, 0, 0, 0, 0,
    //                                     MouseButton.PRIMARY, 1,
    //                                     false, false, false,
    //                                     false, false, false,
    //                                     false, false, false,
    //                                     false, null));
    // }

    // public void releaseNote(char c) {
    //     Button button = buttonMap.get(c);
    //     if (button == null || !inUse.contains(c))
    //         return;
    //     inUse.remove(c);
    //     button.fireEvent(new MouseEvent(MouseEvent.MOUSE_RELEASED, 0, 0, 0, 0,
    //                                     MouseButton.PRIMARY, 1,
    //                                     false, false, false,
    //                                     false, false, false,
    //                                     false, false, false,
    //                                     false, null));
    // }

    // private void setKeyMap() {
    //     buttonMap.put('q', C1);
    //     buttonMap.put('W', Db1);
    //     buttonMap.put('w', D1);
    //     buttonMap.put('E', Eb1);
    //     buttonMap.put('e', E1);
    //     buttonMap.put('r', F1);
    //     buttonMap.put('T', Gb1);
    //     buttonMap.put('t', G1);
    //     buttonMap.put('Y', Ab1);
    //     buttonMap.put('y', A1);
    //     buttonMap.put('U', Bb1);
    //     buttonMap.put('u', B1);

    //     buttonMap.put('a', C2);
    //     buttonMap.put('S', Db2);
    //     buttonMap.put('s', D2);
    //     buttonMap.put('D', Eb2);
    //     buttonMap.put('d', E2);
    //     buttonMap.put('f', F2);
    //     buttonMap.put('G', Gb2);
    //     buttonMap.put('g', G2);
    //     buttonMap.put('H', Ab2);
    //     buttonMap.put('h', A2);
    //     buttonMap.put('J', Bb2);
    //     buttonMap.put('j', B2);

    //     buttonMap.put('z', C3);
    //     buttonMap.put('X', Db3);
    //     buttonMap.put('x', D3);
    //     buttonMap.put('C', Eb3);
    //     buttonMap.put('c', E3);
    //     buttonMap.put('v', F3);
    //     buttonMap.put('B', Gb3);
    //     buttonMap.put('b', G3);
    //     buttonMap.put('N', Ab3);
    //     buttonMap.put('n', A3);
    //     buttonMap.put('M', Bb3);
    //     buttonMap.put('m', B3);
    // }

    // private void setMouseEvent() {
    //     C1.setOnMousePressed(e -> {
    //         player.playNote("C1");
    //     });
    //     Db1.setOnMousePressed(e -> {
    //         player.playNote("Db1");
    //     });
    //     D1.setOnMousePressed(e -> {
    //         player.playNote("D1");
    //     });
    //     Eb1.setOnMousePressed(e -> {
    //         player.playNote("Eb1");
    //     });
    //     E1.setOnMousePressed(e -> {
    //         player.playNote("E1");
    //     });
    //     F1.setOnMousePressed(e -> {
    //         player.playNote("F1");
    //     });
    //     Gb1.setOnMousePressed(e -> {
    //         player.playNote("Gb1");
    //     });
    //     G1.setOnMousePressed(e -> {
    //         player.playNote("G1");
    //     });
    //     Ab1.setOnMousePressed(e -> {
    //         player.playNote("Ab1");
    //     });
    //     A1.setOnMousePressed(e -> {
    //         player.playNote("A1");
    //     });
    //     Bb1.setOnMousePressed(e -> {
    //         player.playNote("Bb1");
    //     });
    //     B1.setOnMousePressed(e -> {
    //         player.playNote("B1");
    //     });
        
    //     C2.setOnMousePressed(e -> {
    //         player.playNote("C2");
    //     });
    //     Db2.setOnMousePressed(e -> {
    //         player.playNote("Db2");
    //     });
    //     D2.setOnMousePressed(e -> {
    //         player.playNote("D2");
    //     });
    //     Eb2.setOnMousePressed(e -> {
    //         player.playNote("Eb2");
    //     });
    //     E2.setOnMousePressed(e -> {
    //         player.playNote("E2");
    //     });
    //     F2.setOnMousePressed(e -> {
    //         player.playNote("F2");
    //     });
    //     Gb2.setOnMousePressed(e -> {
    //         player.playNote("Gb2");
    //     });
    //     G2.setOnMousePressed(e -> {
    //         player.playNote("G2");
    //     });
    //     Ab2.setOnMousePressed(e -> {
    //         player.playNote("Ab2");
    //     });
    //     A2.setOnMousePressed(e -> {
    //         player.playNote("A2");
    //     });
    //     Bb2.setOnMousePressed(e -> {
    //         player.playNote("Bb2");
    //     });
    //     B2.setOnMousePressed(e -> {
    //         player.playNote("B2");
    //     });
        
    //     C3.setOnMousePressed(e -> {
    //         player.playNote("C3");
    //     });
    //     Db3.setOnMousePressed(e -> {
    //         player.playNote("Db3");
    //     });
    //     D3.setOnMousePressed(e -> {
    //         player.playNote("D3");
    //     });
    //     Eb3.setOnMousePressed(e -> {
    //         player.playNote("Eb3");
    //     });
    //     E3.setOnMousePressed(e -> {
    //         player.playNote("E3");
    //     });
    //     F3.setOnMousePressed(e -> {
    //         player.playNote("F3");
    //     });
    //     Gb3.setOnMousePressed(e -> {
    //         player.playNote("Gb3");
    //     });
    //     G3.setOnMousePressed(e -> {
    //         player.playNote("G3");
    //     });
    //     Ab3.setOnMousePressed(e -> {
    //         player.playNote("Ab3");
    //     });
    //     A3.setOnMousePressed(e -> {
    //         player.playNote("A3");
    //     });
    //     Bb3.setOnMousePressed(e -> {
    //         player.playNote("Bb3");
    //     });
    //     B3.setOnMousePressed(e -> {
    //         player.playNote("B3");
    //     });
    // }
}
