### Statement

There are `n` kids with candies. You are given an integer array `candies`, where each `candies[i]` represents the number of candies the ith kid has, and an integer `extraCandies`, denoting the number of extra candies that you have.

Return a boolean array `result` of length `n`, where `result[i]` is true if, after giving the ith kid all the `extraCandies`, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.

### Solution

The optimal approach to solve this problem is to first find the maximum number of candies that any kid currently has. Then, for each kid, we check if giving them all the `extraCandies` would make their total candies greater than or equal to this maximum. If it does, we set the corresponding entry in the result array to `true`; otherwise, we set it to `false`.
