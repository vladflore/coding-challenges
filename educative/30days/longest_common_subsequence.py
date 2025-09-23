def longest_common_subsequence(str1, str2):
    '''
    Suppose you are given two strings. You need to find the length of the longest common subsequence between these two strings.

A subsequence is a string formed by removing some characters from the original string while maintaining the relative position of the remaining characters. For example, “abd” is a subsequence of “abcd”, where the removed character is “c”.

If there is no common subsequence, then return 0.
    '''
    m, n = len(str1), len(str2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if str1[i - 1] == str2[j - 1]:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    
    return dp[m][n]

