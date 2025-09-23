def can_partition_array(nums):
    '''
    Given a non-empty array of positive integers, determine if the array can be divided into two subsets so that the sum of both subsets is equal.
    '''
    total = sum(nums)
    if total % 2 != 0:
        return False
    target = total // 2
    dp = [False] * (target + 1)
    dp[0] = True
    for num in nums:
        for s in range(target, num - 1, -1):
            dp[s] = dp[s] or dp[s - num]
    return dp[target]
