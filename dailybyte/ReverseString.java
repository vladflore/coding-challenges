public class ReverseString {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Program requires one string argument");
            return;
        }
        System.out.println(new ReverseString().solve1(args[0]));
        System.out.println(new ReverseString().solve2(args[0]));
    }

    private String solve1(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private String solve2(String string) {
        StringBuilder reversed = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed.append(string.charAt(i));
        }
        return reversed.toString();
    }
}