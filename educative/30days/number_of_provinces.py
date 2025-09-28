from union_find import UnionFind

def find_connected_cities(cities):
    '''
    Given n cities, some are directly connected, and others are not. You are given an n×n matrix called cities, where cities[i][j] = 1
 means city ith and city jth are directly connected, and cities[i][j] =0 means they are not directly connected.
The task is to return the total number of groups of connected cities directly or indirectly. These groups are referred to as provinces.
    '''
    n = len(cities)
    uf = UnionFind(n)

    for i in range(n):
        for j in range(i + 1, n):
            if cities[i][j] == 1:
                uf.union(i, j)

    roots = set()
    for i in range(n):
        roots.add(uf.find(i))

    return len(roots)

