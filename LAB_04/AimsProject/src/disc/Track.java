package disc;

public class Track implements Playable{

    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track)obj;
            return this.title.equals(other.title) &&
                    this.length == other.length;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Track - " +
                "Title: " + title +
                ", Length: " + length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + getTitle());
        System.out.println("Track length: " + getLength());
    }
}