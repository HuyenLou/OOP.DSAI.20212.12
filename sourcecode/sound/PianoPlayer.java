package sound;

public class PianoPlayer extends Player {
    public PianoPlayer() {
        jfPlayer.changeInstrument(0);
    }

    @Override
    public void playNote(String note) {
        playNote(note, 5);
    }
}
