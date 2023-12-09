package cart;

import disc.Media;

import java.util.Comparator;

public class TitleComparator implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {

        // So sánh theo tiêu đề
        int result = m1.getTitle().compareTo(m2.getTitle());
        if (result == 0) {
            // Nếu trùng tiêu đề thì so sánh giá
            result = Float.compare(m2.getCost(), m1.getCost());
        }

        return result;
    }

}