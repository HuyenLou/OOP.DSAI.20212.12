package sound;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

public abstract class Player {
    protected RealtimePlayer jfPlayer;
    protected byte volume;

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

    protected void playNote(String str, int octave) {
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
                return;
        }
        if (str.contains("#")) note += 1;
        if (str.contains("b")) note -= 1;
        if (str.length() > 1) {
            char c = str.charAt(str.length() - 1);
            octave += c - '1';
        }
        note += octave * 12;
        jfPlayer.startNote(new Note(note));
    }

    public void setVolume(byte volume) {
        this.volume = volume;
        jfPlayer.changeController((byte)7, volume);
    }

    public byte getVolume() {
        return volume;
    }

    public abstract void playNote(String note);
}
