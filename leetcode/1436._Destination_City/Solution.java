import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));
        System.out.println(new Solution().destCity(paths));

        paths = List.of(
                List.of("B", "C"),
                List.of("D", "B"),
                List.of("C", "A"));
        System.out.println(new Solution().destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        Set<String> destinations = new HashSet<>();
        Set<String> origins = new HashSet<>();
        for (List<String> path : paths) {
            origins.add(path.get(0));
            destinations.add(path.get(1));
        }
        destinations.removeAll(origins);
        return destinations.stream().collect(Collectors.joining());
    }

    public String destCity1(List<List<String>> paths) {
        Set<String> origins = new HashSet<>();
        for (List<String> path : paths) {
            origins.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!origins.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
