package teststore;

import disc.DigitalVideoDisc;
import store.Store;

public class StoreTest {

    public static void main(String[] args) {

        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Aladdin", "Animation", 15.95f, "John Musker", 90);

        store.addMedia(dvd1);
        store.addMedia(dvd2);

        store.removeMedia(dvd1);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Cinderella", "Animation", 12.95f,"Walt Disney", 88);

        store.addMedia(dvd3);

    }

}
