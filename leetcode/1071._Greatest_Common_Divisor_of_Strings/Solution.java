public class Solution {
	public String gcdOfStrings(String str1, String str2) {
		if(!(str1 + str2).equals(str2 + str1)){
			return "";
		}
		var gcdLength = gcd(str1.length(), str2.length());

		return str1.substring(0, gcdLength);
	}

	private int gcd(int a, int b) {
		// gcd(a, b) = gcd (b, a % b)
		// repeat until b = 0
		// return a
		while(b != 0){
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		var s = new Solution();
		System.out.println("ABC".equals(s.gcdOfStrings("ABCABC", "ABC")));
		System.out.println("ABC".equals(s.gcdOfStrings("ABC", "ABCABC")));
		System.out.println("AB".equals(s.gcdOfStrings("ABABAB", "ABAB")));
		System.out.println("".equals(s.gcdOfStrings("LEET", "CODE")));
	}	
}
