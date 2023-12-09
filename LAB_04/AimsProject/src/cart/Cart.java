package cart;

import disc.DigitalVideoDisc;
import disc.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The media " + media.getTitle() + " has been added!");
    }

    public void addMedia(Media... items) {
        for (Media item: items) {
            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full!");
                return;
            }
            itemsOrdered.add(item);
            System.out.println("The media " + item.getTitle() + " has been added");
        }
    }

    public void addMedia(Media media1, Media media2) {
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media1);
            System.out.println("The media " + media1.getTitle() + " has been added");
        } else {
            System.out.println("The cart is almost full!");
        }
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media2);
            System.out.println("The media " + media2.getTitle() + " has been added");
        } else {
            System.out.println("The cart is almost full!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed successfully!");
        } else {
            System.out.println("The media is not existed!");
        }
    }

    public float totalCost() {
        float cost = 0;
        for (Media item : itemsOrdered) {
            cost += item.getCost();
        }
        return cost;
    }

    public void printCart(){
        System.out.println("***********************CART***********************");
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Media> searchByTitle(String title) {
        List<Media> foundItems = new ArrayList<>();
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public void displayCart() {
        for(int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%-5d%-30s%.2f\n", i + 1, itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCost());
        }
        System.out.printf("%5s%-30s%.2f"," ","Total Cost", totalCost());
    }

    public int getQtyOrdered() {
        return itemsOrdered.size();
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, new TitleComparator());
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, new CostComparator());
    }

    public void sortMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                sortByTitle();
                break;

            case 2:
                sortByCost();
                break;

            default:
                System.out.println("Invalid choice!");
        }

    }

    public float calculateTotalCost() {
        float total = 0;
        for(Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }
    public void print() {
        System.out.println("---------------CART---------------");
        for(Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total cost: " + calculateTotalCost());
    }

    public Media getMedia(int id) {
        for(Media media : itemsOrdered) {
            if(media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart cleared!");
    }
}