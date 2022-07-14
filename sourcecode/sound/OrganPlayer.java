package sound;

public class OrganPlayer extends Player {
    public OrganPlayer() {
        jfPlayer.changeInstrument(17);
    }

    @Override
    public void playNote(String note) {
        playNote(note, 5);
    }

    @Override
    public void stopNote(String note) { stopNote(note, 5); }
}
