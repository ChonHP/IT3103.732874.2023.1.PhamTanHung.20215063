package disc;
public class DigitalVideoDisc extends Media implements Playable {

    private String director;
    private int length;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public boolean isMatch(String title) {

        String[] titleSplit = this.getTitle().split(" ");
        String[] enterTitleSplit = title.split(" ");

        boolean match = true;

        for(int i=0; i<titleSplit.length; i++) {
            if(!titleSplit[i].equalsIgnoreCase(enterTitleSplit[i])) {
                match = false;
                break;
            }
        }
        return match;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}