def binary_search(nums: list[int], target: int) -> int:
    low, high = 0, len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('binary_search([-1, 0, 3, 5, 9, 12], 9)', binary_search([-1, 0, 3, 5, 9, 12], 9), 4),
        check('binary_search([-1, 0, 3, 5, 9, 12], 2)', binary_search([-1, 0, 3, 5, 9, 12], 2), -1),
        check('binary_search([], 1)', binary_search([], 1), -1),
        check('binary_search([5], 5)', binary_search([5], 5), 0),
        check('binary_search([1, 3], 1)', binary_search([1, 3], 1), 0),
        check('binary_search([1, 3], 3)', binary_search([1, 3], 3), 1),
        check('binary_search([-1, 0, 3, 5, 9, 12], 12)', binary_search([-1, 0, 3, 5, 9, 12], 12), 5),
    ]
    print(f"{sum(results)}/{len(results)} passed")
