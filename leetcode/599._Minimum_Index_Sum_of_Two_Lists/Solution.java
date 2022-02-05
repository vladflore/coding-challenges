import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        String[] res = new Solution().findRestaurant(
                new String[] { "Shogun","Tapioca Express","Burger King","KFC" },
                new String[] { "KFC","Shogun","Burger King" });
        System.out.println(Arrays.toString(res));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurants = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            restaurants.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (restaurants.containsKey(list2[i])) {
                int indicesSum = restaurants.get(list2[i]) + i;
                if (indicesSum < minSum) {
                    ans.clear();
                    ans.add(list2[i]);
                    minSum = indicesSum;
                } else if (indicesSum == minSum) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}