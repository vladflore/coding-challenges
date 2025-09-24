def count_negatives(grid):
    '''
    Given a matrix grid of size m∗n, where each row and column is sorted in non-increasing order, find and return the total count of negative numbers in the matrix.
    '''
    m = len(grid) - 1
    n = len(grid[0]) - 1
    count = 0
    for i in range(m, -1, -1):
        for j in range(n, -1, -1):
            if grid[i][j] < 0:
                count += 1
    return count

