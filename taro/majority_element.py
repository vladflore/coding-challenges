class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        from collections import Counter
        counter = Counter(nums)
        for num, count in counter.items():
            if count > len(nums) // 2:
                return num
                
