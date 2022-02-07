package practice.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 */
public class FilterRestaurants {
    public static void main(String[] args) {
        int[][] restaurants = new int[][] {
                { 1, 4, 1, 40, 10 }, { 2, 8, 0, 50, 5 }, { 3, 8, 1, 30, 4 }, { 4, 10, 0, 10, 3 }, { 5, 1, 1, 15, 1 }
        };
        // System.out.println(new Solution().filterRestaurants(restaurants, 1, 50, 10));
        System.out.println(new Solution().filterRestaurants1(restaurants, 1, 50, 10));
    }
}

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants)
                .filter(restaurant -> veganFriendly == 0 || restaurant[2] == veganFriendly)
                .filter(restaurant -> restaurant[3] <= maxPrice)
                .filter(restaurant -> restaurant[4] <= maxDistance)
                .sorted(Comparator.<int[]>comparingInt(restaurant -> -restaurant[1])
                        .thenComparing(restaurant -> -restaurant[0]))
                .map(restaurant -> restaurant[0]).collect(Collectors.toList());
    }

    public List<Integer> filterRestaurants1(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Comparator<Restaurant> byRating = Comparator.comparing(Restaurant::getRating).reversed();
        Comparator<Restaurant> byId = Comparator.comparing(Restaurant::getId).reversed();
        Function<int[], Restaurant> toRestaurant = r -> new Restaurant(r[0], r[1], r[2], r[3], r[4]);
        Predicate<Restaurant> isVeganFriendly = r -> veganFriendly == 0 || r.veganFriendly == veganFriendly;
        Predicate<Restaurant> withMaxPrice = r -> r.price <= maxPrice;
        Predicate<Restaurant> withMaxDistance = r -> r.distance <= maxDistance;

        return Stream.of(restaurants)
                .map(toRestaurant)
                .filter(isVeganFriendly)
                .filter(withMaxPrice)
                .filter(withMaxDistance)
                .sorted(byRating.thenComparing(byId))
                .map(r -> r.id).collect(Collectors.toList());
    }
}

class Restaurant {
    public int id;
    public int rating;
    public int veganFriendly;
    public int price;
    public int distance;

    Restaurant(int id,
            int rating,
            int veganFriendly,
            int price,
            int distance) {
        this.id = id;
        this.rating = rating;
        this.veganFriendly = veganFriendly;
        this.price = price;
        this.distance = distance;
    }

    public int getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

}