from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        from collections import Counter
        counter = Counter(nums)
        for num, count in counter.items():
            if count > len(nums) // 2:
                return num


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('majorityElement([3, 2, 3])', Solution().majorityElement([3, 2, 3]), 3),
        check('majorityElement([2, 2, 1, 1, 1, 2, 2])', Solution().majorityElement([2, 2, 1, 1, 1, 2, 2]), 2),
        check('majorityElement([1])', Solution().majorityElement([1]), 1),
        check('majorityElement([5, 5, 6])', Solution().majorityElement([5, 5, 6]), 5),
    ]
    print(f"{sum(results)}/{len(results)} passed")
