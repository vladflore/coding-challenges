def num_decodings(s: str) -> int:
    if not s or s[0] == "0":
        return 0

    n = len(s)
    dp = [0] * (n + 1)
    dp[0] = 1
    dp[1] = 1

    for i in range(2, n + 1):
        one = int(s[i-1])        # single digit
        two = int(s[i-2:i])      # double digit

        if one >= 1:
            dp[i] += dp[i-1]
        if 10 <= two <= 26:
            dp[i] += dp[i-2]

    return dp[n]


# Example
print(num_decodings("231012"))  # Output: 4

