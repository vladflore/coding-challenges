class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int i = 0;
		int planted = 0;
		while (i < flowerbed.length) {
			if (flowerbed[i] == 1) {
				i += 1;
				continue;
			}
			boolean leftEmpty = (i == 0) || flowerbed[i - 1] == 0;
			boolean rightEmpty = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;
			if (!leftEmpty || !rightEmpty) {
				i += 1;
				continue;
			}
			flowerbed[i] = 1;
			planted++;
			i += 2;
		}
		return planted >= n;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1)); // true
		System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2)); // false
		System.out.println(s.canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1)); // true
	}
}
