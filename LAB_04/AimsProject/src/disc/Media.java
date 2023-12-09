package disc;

public abstract class Media {

    int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {

    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media other = (Media)obj;
            return this.title.equals(other.title);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Media - " +
                "ID: " + id +
                ", Title: " + title +
                ", Category: " + category +
                ", Cost: " + cost;
    }
}