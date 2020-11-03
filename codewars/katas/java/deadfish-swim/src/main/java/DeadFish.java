import java.util.ArrayList;
import java.util.List;

public class DeadFish {

/*
    Write a simple parser that will parse and run Deadfish.
    Deadfish has 4 commands, each 1 character long:
    i increments the value (initially 0)
    d decrements the value
    s squares the value
    o outputs the value into the return array
    Invalid characters should be ignored.
 */

    public static int[] parse(String data) {
        int value = 0;
        List<Integer> ans = new ArrayList<>();
        String[] letters = data.split("");
        for (String letter : letters) {
            switch (letter) {
                case "i":
                    value++;
                    break;
                case "d":
                    value--;
                    break;
                case "s":
                    value = value * value;
                    break;
                case "o":
                    ans.add(value);
                    break;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
