public class Kata {
    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            int l = currentWord.length();
            if (l > 0) {
                stringBuilder.append((int) currentWord.charAt(0));
                if (l > 1) {
                    stringBuilder.append(currentWord.charAt(currentWord.length() - 1));
                    if (l > 2) {
                        stringBuilder.append(currentWord.substring(2, currentWord.length() - 1));
                        stringBuilder.append(currentWord.charAt(1));
                    }
                }
            }
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(encryptThis("A wise old owl lived in an oak"));
    }
}