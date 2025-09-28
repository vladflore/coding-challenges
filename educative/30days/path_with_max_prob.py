from collections import defaultdict
import heapq

def max_probability(n, edges, succProb, start, end):
    
    graph = defaultdict(list)
    for (a, b), prob in zip(edges, succProb):
        graph[a].append((b, prob))
        graph[b].append((a, prob))

    heap = [(-1.0, start)]
    max_prob = [0.0] * n
    max_prob[start] = 1.0

    while heap:
        prob, node = heapq.heappop(heap)
        prob = -prob

        if node == end:
            return prob

        for nei, edge_prob in graph[node]:
            new_prob = prob * edge_prob
            if new_prob > max_prob[nei]:
                max_prob[nei] = new_prob
                heapq.heappush(heap, (-new_prob, nei))

    return 0.0

