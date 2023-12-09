package cart;

import disc.Media;

import java.util.Comparator;

public class CostComparator implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {

        // So sánh theo giá
        int result = Float.compare(m2.getCost(), m1.getCost());
        if (result == 0) {
            // Nếu giá trùng thì so sánh theo tên
            result = m1.getTitle().compareTo(m2.getTitle());
        }

        return result;
    }

}