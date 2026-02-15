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


if __name__ == "__main__":
    assert 4 == binary_search([-1, 0, 3, 5, 9, 12], 9)
    assert -1 == binary_search([-1, 0, 3, 5, 9, 12], 2)
    assert -1 == binary_search([], -1)
    assert 0 == binary_search([7], 7)
    assert 5 == binary_search([-1, 0, 3, 5, 9, 12], 12)
    assert 0 == binary_search([-1, 0, 3, 5, 9, 12], -1)
