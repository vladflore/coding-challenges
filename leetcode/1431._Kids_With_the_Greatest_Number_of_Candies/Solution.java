import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // int max = Arrays.stream(candies).max().orElse(0);
        // return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).toList();
        int max = Integer.MIN_VALUE;
        for(int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        for(int candy: candies) {
            result.add((candy + extraCandies) >= max);
        }
        return result;
    }
}
