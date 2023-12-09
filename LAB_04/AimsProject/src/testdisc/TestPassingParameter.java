package testdisc;

import disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle", "Learning Java", 10f, "朝日", 22);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella", "Learning Java", 10f, "朝日", 22);

        swap(jungleDVD, cinderellaDVD);

        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc temp = dvd1;
        dvd1 = dvd2;
        dvd2 = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);

        dvd = new DigitalVideoDisc(3, oldTitle, "Learning Java", 10f, "朝日", 22);
    }

}