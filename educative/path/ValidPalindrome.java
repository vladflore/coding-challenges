void main() {
    System.out.println(isPalindrome("a"));
    System.out.println(isPalindrome("ab"));
    System.out.println(isPalindrome("aba"));
    System.out.println(isPalindrome("abba"));
    System.out.println(isPalindrome("abbaa"));
}

boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}