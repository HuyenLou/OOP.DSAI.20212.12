package sound;

public class GuitarPlayer extends Player {
    public GuitarPlayer() {
        jfPlayer.changeInstrument(24);
    }

    @Override
    public void playNote(String note) {
        playNote(note, 5);
    }

    @Override
    public void stopNote(String note) {}
}
