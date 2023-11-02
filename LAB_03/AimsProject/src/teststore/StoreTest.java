package teststore;

import disc.DigitalVideoDisc;
import store.Store;

public class StoreTest {

    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin");

        store.addDVD(dvd1);
        store.addDVD(dvd2);

        store.removeDVD(dvd1);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Cinderella");
        store.addDVD(dvd3);
    }

}
