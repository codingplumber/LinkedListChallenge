package jason.company;

public class Song {
    private String title;
    private int trackNumber;
    private Double duration;

    public Song(String title, Double duration, int trackNumber) {
        this.title = title;
        this.duration = duration;
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }
}
