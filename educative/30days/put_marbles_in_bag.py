def put_marbles(weights, k):
    # If k is 1, all marbles must be in one bag, hence no partitioning is needed
    if k == 1:
        return 0

    # Calculate the cost of the initial single bag with all marbles
    n = len(weights)
    initial_cost = weights[0] + weights[-1]

    # Calculate the pairwise sums
    pairwise_sums = [weights[i] + weights[i + 1] for i in range(n - 1)]

    # Sort the pairwise sums to help find the max and min scores
    pairwise_sums.sort()

    # Calculate the maximum score by selecting largest (k-1) pairwise sums
    max_score = initial_cost + sum(pairwise_sums[-(k-1):])

    # Calculate the minimum score by selecting smallest (k-1) pairwise sums
    min_score = initial_cost + sum(pairwise_sums[:k-1])

    # Return the difference between maximum and minimum scores
    return max_score - min_score


def main():
    test_cases = [
        ([5], 1),
        ([1, 7, 23, 29, 47], 3),
        ([1, 2, 3, 5], 4),
        ([1, 2, 3, 5], 2),
        ([1, 13, 17, 19, 23, 29, 31], 4)
    ]

    for idx, (weights, k) in enumerate(test_cases, start=1):
        print(f"{idx}.\tweights: {weights}, k: {k}")
        result = put_marbles(weights, k)
        print(f"\tMaximum score difference: {result}")
        print("-" * 100)

if __name__ == '__main__':
    main()

