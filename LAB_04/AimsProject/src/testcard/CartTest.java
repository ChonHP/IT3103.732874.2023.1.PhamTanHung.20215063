package testcard;

import cart.Cart;
import disc.DigitalVideoDisc;
import disc.Media;

import java.util.List;

public class CartTest {

    private Cart cart;

    public CartTest() {
        cart = new Cart();
    }

    public void testAddDigitalVideoDisc() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Aladdin", "Animation", 15.95f, "John Musker", 90);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);

        int expectedQty = 2;
        int actualQty = cart.getQtyOrdered();

        checkEquals(expectedQty, actualQty);
    }

    public void testRemoveDigitalVideoDisc() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        cart.addMedia(dvd1);

        cart.removeMedia(dvd1);

        int expectedQty = 0;
        int actualQty = cart.getQtyOrdered();

        checkEquals(expectedQty, actualQty);
    }

    public void testSearchById() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        cart.addMedia(dvd1);

        DigitalVideoDisc foundDvd = (DigitalVideoDisc) cart.searchById(1);

        checkEquals("The Lion King", foundDvd.getTitle());
    }

    public void testSearchByTitle() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc (1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        cart.addMedia(dvd1);

        List<Media> found = cart.searchByTitle("The Lion King");

        checkEquals(1, found.size());
        checkEquals("The Lion King", found.get(0).getTitle());
    }

    public void checkEquals(int expected, int actual) {

        if (expected != actual) {
            throw new RuntimeException("Test failed!");
        } else {
            System.out.println("Test passed!");
        }
    }

    public void checkEquals(String expected, String actual) {

        if (!expected.equals(actual)) {
            throw new RuntimeException("Test failed!");
        } else {
            System.out.println("Test passed!");
        }
    }

    public static void main(String[] args) {

        CartTest test = new CartTest();

        test.testAddDigitalVideoDisc();
        test.testRemoveDigitalVideoDisc();
        test.testSearchById();
        test.testSearchByTitle();

    }

}