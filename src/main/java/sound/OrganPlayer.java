package sound;

public class OrganPlayer extends Player {
    public OrganPlayer() {
        jfPlayer.changeInstrument(22);
    }

    @Override
    public void playNote(String note) {
        playNote(note, 5);
    }
}
