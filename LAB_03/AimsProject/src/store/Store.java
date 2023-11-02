package store;

import disc.DigitalVideoDisc;

public class Store {

    private DigitalVideoDisc[] itemsInStore;
    private int numItems = 0;

    public Store() {
        itemsInStore = new DigitalVideoDisc[100];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if(numItems == itemsInStore.length) {
            System.out.println("The store is full!");
        } else {
            itemsInStore[numItems] = dvd;
            numItems++;
            System.out.println("DVD added successfully!");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for(int i = 0; i < numItems; i++) {
            if(itemsInStore[i] == dvd) {
                for(int j = i; j < numItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j+1];
                }
                numItems--;
                System.out.println("DVD removed successfully!");
                return;
            }
        }
        System.out.println("DVD not found!");
    }

}
