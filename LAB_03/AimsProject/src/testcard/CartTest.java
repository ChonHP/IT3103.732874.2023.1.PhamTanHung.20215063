package testcard;

import cart.Cart;
import disc.DigitalVideoDisc;

import java.util.List;

public class CartTest {

    private Cart cart;

    public CartTest() {
        cart = new Cart();
    }

    public void testAddDigitalVideoDisc() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin");

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);

        int expectedQty = 2;
        int actualQty = cart.getQtyOrdered();
        checkEquals(expectedQty, actualQty);
    }

    public void testRemoveDigitalVideoDisc() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        cart.addDigitalVideoDisc(dvd1);

        cart.removeDigitalVideoDisc(dvd1);

        int expectedQty = 0;
        int actualQty = cart.getQtyOrdered();
        checkEquals(expectedQty, actualQty);
    }

    public void testSearchById() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setId(1);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc foundDvd = cart.searchById(1);

        checkEquals("The Lion King", foundDvd.getTitle());
    }

    public void testSearchByTitle() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        cart.addDigitalVideoDisc(dvd1);

        List<DigitalVideoDisc> found = cart.searchByTitle("The Lion King");

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