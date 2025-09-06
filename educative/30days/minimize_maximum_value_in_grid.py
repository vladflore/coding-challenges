def minimize_max_value(grid):
    '''
    You are given an m x n integer matrix, grid, containing distinct positive integers.

Your task is to replace each integer in the matrix with a positive integer such that the following conditions are satisfied:

1. Preserve relative order: The relative order of every two elements that are in the same row or column should stay the same after the replacements.

2. Minimize maximum value: The maximum number in the matrix after the replacement should be as small as possible.

The relative order is preserved if, for all pairs of elements in the original matrix, the following condition holds:

If grid[r1][c1] > grid[r2][c2] and either r1 == r2 or c1 == c2, then the corresponding replacement values must also satisfy grid[r1][c1] > grid[r2][c2].

For example, if grid = [[2, 4, 5], [6, 3, 8]], valid replacements could be:

[[1, 2, 3], [2, 1, 4]]

[[1, 2, 3], [3, 1, 4]]

Return the resulting matrix after the replacement. If there are multiple valid solutions, return any of them.

    '''
    m, n = len(grid), len(grid[0])
    
    best_in_row = [0] * m
    best_in_col = [0] * n
    new_grid = [[0] * n for _ in range(m)]

    cells = [(grid[r][c], r, c) for r in range(m) for c in range(n)]
    cells.sort()
    
    for val, r, c in cells:
        new_val = 1 + max(best_in_row[r], best_in_col[c])
        new_grid[r][c] = new_val
        best_in_row[r] = max(best_in_row[r], new_val)
        best_in_col[c] = max(best_in_col[c], new_val)
    
    return new_grid
