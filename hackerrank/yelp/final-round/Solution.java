import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * This is not the original problem.
 * 
 * The idea is that you have a list of some objects, a specific object and it is
 * asked from you to calculate some similarity between that object and each of
 * the objects in the list. Out of this information return the object with the
 * max similarity, objects with the same similarity are differentiated by
 * another field they contain(numberOfReviews). Sort by similarity desc, by
 * number of reviews desc.
 * 
 */
public class Solution {

    public static void main(String[] args) {

        Map<Book, Float> similarities = new HashMap<>();

        // this is some dummy data
        similarities.put(new Book(1, 5), 0.66f);
        similarities.put(new Book(2, 6), 0.55f);
        similarities.put(new Book(3, 1), 0.66f);
        similarities.put(new Book(4, 7), 0.89f);
        similarities.put(new Book(5, 9), 0.63f);

        // result: 4
        // 1 3 5 2

        // sort by similarity desc and then by number of reviews desc and return the
        // first book

        Comparator<Map.Entry<Book, Float>> byValueDesc = Comparator
                .comparing(Map.Entry<Book, Float>::getValue).reversed();

        Comparator<Map.Entry<Book, Float>> byReviewsDesc = Comparator.comparing(Map.Entry<Book, Float>::getKey,
                (b1, b2) -> Integer.compare(b1.numberOfReviews, b2.numberOfReviews)).reversed();

        Comparator<Map.Entry<Book, Float>> byEntryBookReviews = (e1, e2) -> Integer.compare(e1.getKey().numberOfReviews,
                e2.getKey().numberOfReviews);

        Comparator<Book> byBookReviews = (b1, b2) -> Integer.compare(b1.numberOfReviews, b2.numberOfReviews);

        // Optional<Entry<Book, Float>> bookEntry =
        similarities.entrySet()
                .stream()
                .sorted(Map.Entry.<Book, Float>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.<Book, Float>comparingByKey(byBookReviews.reversed())))
                // .sorted(byValueDesc.thenComparing(byReviewsDesc))
                .forEach(e -> System.out.println(e.getKey()));
        // .findFirst();
        // if (bookEntry.isPresent()) {
        // System.out.println(bookEntry.get().getKey());
        // }
    }
}

class Book {
    public int id;
    public int numberOfReviews;

    public Book(int id, int numberOfReviews) {
        this.id = id;
        this.numberOfReviews = numberOfReviews;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}