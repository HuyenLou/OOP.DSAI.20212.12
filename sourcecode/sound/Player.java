package sound;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

import javafx.scene.control.TextField;

public abstract class Player {
    protected RealtimePlayer jfPlayer;
    private byte volume;
    private  String text="";
    public String getText() {
        return this.text;
    }
    public void setText(String str) {
        this.text =str;
    }

    public Player() {
        try {
            jfPlayer = new RealtimePlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        jfPlayer.close();
    }

    private Note getNote(String str, int octave) {
        int note;
        switch (str.charAt(0)) {
            case 'C': note = 0; break;
            case 'D': note = 2; break;
            case 'E': note = 4; break;
            case 'F': note = 5; break;
            case 'G': note = 7; break;
            case 'A': note = 9; break;
            case 'B': note = 11; break;
            default:
                System.out.println("Invalid note " + str.charAt(0));
                return null;
        }
        if (str.contains("#")) note += 1;
        if (str.contains("b")) note -= 1;
        if (str.length() > 1) {
            char c = str.charAt(str.length() - 1);
            octave += c - '1';
        }
        note += octave * 12;
        return new Note(note);
    }

    protected void playNote(String str, int octave) {
        text=text+ str+ " ";
        jfPlayer.startNote(getNote(str, octave));
    }

    protected void stopNote(String str, int octave) {
        jfPlayer.stopNote(getNote(str, octave));
    }

    public void setVolume(float volume) {
        this.volume = (byte) (volume * 127 / 100);
        jfPlayer.changeController((byte)7, this.volume);
    }

    public byte getVolume() {
        return volume;
    }

    public abstract void playNote(String note);
    public abstract void stopNote(String note);
}