package disc;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors;

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }

    public void addAuthor(String authorName) {
        if(!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book - " + super.toString() +
                " - Authors: " + String.join(", ", authors);
    }
}