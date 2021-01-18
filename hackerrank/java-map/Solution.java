import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Map<String, String> phoneBook = new HashMap<>();
        List<String> output = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            String phone = in.nextLine();
            phoneBook.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            String entry = (phoneBook.get(s) != null ? s + "=" + phoneBook.get(s) : "Not found");
            output.add(entry);
        }
        for (String person : output) {
            System.out.println(person);
        }
    }
}




