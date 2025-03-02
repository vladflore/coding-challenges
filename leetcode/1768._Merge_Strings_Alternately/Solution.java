class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] merged = new char[word1.length() + word2.length()];

        int i = 0;
        int k = 0;
        boolean left = true;
        while(i < word1.length() && i < word2.length()) {
            char c = left ? word1.charAt(i) : word2.charAt(i);
            merged[k++] = c;
            left = !left;
            if (left) i++;
        }
        while(i < word1.length()) {
            merged[k++] = word1.charAt(i);
            i++;
        }

        while(i < word2.length()) {
            merged[k++] = word2.charAt(i);
            i++;
        }

        return new String(merged);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        if(!"adbecf".equals(s.mergeAlternately("abc", "def"))) {
            throw new IllegalStateException("Wrong answer.");
        } else {
            System.out.println("Correct");
        }
        if(!"adbecfg".equals(s.mergeAlternately("abc", "defg"))) {
            throw new IllegalStateException("Wrong answer.");
        } else {
            System.out.println("Correct");
        }
    }

}
