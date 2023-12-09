package store;

import disc.DigitalVideoDisc;
import disc.Media;

import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media " + media.getTitle() + " added successfully!");
    }

    public void removeMedia(Media media) {
        if(!itemsInStore.remove(media)) {
            System.out.println("Media not found!");
        } else {
            System.out.println("Media " + media.getTitle() + " removed successfully!");
        }
    }

    public float totalCost() {
        float total = 0;
        for(Media item : itemsInStore) {
            total += item.getCost();
        }
        return total;
    }
    public void print() {
        System.out.println("-------------STORE-------------");
        for(Media m : itemsInStore) {
            System.out.println(m);
        }
    }

    public Media getMediaById(int id) {
        for(Media m : itemsInStore) {
            if(m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}
