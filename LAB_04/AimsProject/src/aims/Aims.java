package aims;

import cart.Cart;
import disc.Book;
import disc.DigitalVideoDisc;
import disc.Media;
import store.Store;

import java.util.Scanner;

public class Aims {

    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. View cart");
        System.out.println("0. Exit");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                storeMenu();
                break;

            case 2:
                cartMenu();
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void storeMenu() {
        System.out.println("Store menu: ");
        System.out.println("1. View items");
        System.out.println("0. Back");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                viewStoreItems();
                break;

            case 2:
                addStoreItem();
                break;

            case 0:
                showMenu();
                break;

            default:
                System.out.println("Invalid choice!");
                storeMenu();
        }

    }

    public static void viewStoreItems() {
        store.print();
    }

    public static void addStoreItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Choose type: ");
        System.out.println("1. Book");
        System.out.println("2. DVD");

        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                // Nhập thông tin và tạo Book
                Book book = new Book(1, title, "Education", 19.95f);
                store.addMedia(book);
                break;

            case 2:
                // Nhập thông tin và tạo DVD
                DigitalVideoDisc dvd = new DigitalVideoDisc(2, title,"Movie", 29.95f, "John", 90);
                store.addMedia(dvd);
                break;

            default:
                System.out.println("Invalid type!");
        }

        System.out.println("Added successfully!");
    }

    public static void cartMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Cart menu:");
            System.out.println("1. View items");
            System.out.println("2. Add item");
            System.out.println("3. Remove item");
            System.out.println("4. Place order");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCartItems();
                    break;
                case 2:
                    addCartItem();
                    break;
                case 3:
                    removeCartItem();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void viewCartItems() {
        cart.print();
    }

    // các phương thức xử lý khác
    public static void addCartItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        int id = scanner.nextInt();

        Media media = store.getMediaById(id);
        if(media == null) {
            System.out.println("Product not found!");
            return;
        }
        cart.addMedia(media);
        System.out.println("Added successfully!");
    }

    public static void removeCartItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID to remove: ");
        int id = scanner.nextInt();

        Media media = cart.getMedia(id);
        if(media == null ) {
            System.out.println("Product not found in cart!");
            return;
        }
        cart.removeMedia(media);
        System.out.println("Removed successfully!");
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.clearCart();
    }
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 10f, "Author 1", 90);
        Book book1 = new Book(1, "Learn Java", "Programming", 12.5f);

        store.addMedia(dvd1);
        store.addMedia(book1);

        showMenu();
    }

}