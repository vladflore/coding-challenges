from collections import defaultdict
import heapq

def max_probability(n, edges, succProb, start, end):
  
    # Build the graph from the given edges and probabilities
    # Use defaultdict to build the graph to easily append neighbors
    graph = defaultdict(list)
    
    # For each edge, store the probability for both directions because the graph is undirected
    for i, (u, v) in enumerate(edges):
      
        # Add edge u -> v with probability succProb[i]
        graph[u].append((v, succProb[i]))
        
        # Add edge v -> u with probability succProb[i]
        graph[v].append((u, succProb[i]))
        
    # Initialize a list to store the maximum probability for each node
    # Start with zero probability for all nodes
    max_prob = [0.0] * n
    
    # Set the probability of the start node to 1 as there 100% probability of reaching the starting node
    max_prob[start] = 1.0

    # Use priority queue (heap) to always process the node with the highest probability
    # The heap stores tuples of (-probability, node) so that the largest probability comes first
    # Start with the start node having probability 1.0 (stored as -1.0)
    pq = [(-1.0, start)]
    while pq:
      
        # Pop the node with the highest probability from the priority queue
        cur_prob, cur_node = heapq.heappop(pq)
        
        # If we have reached the end node, return the probability (note: we used negative probability)
        if cur_node == end:
          
            # The probability is stored as negative to simulate a max heap
            return -cur_prob

        # Explore neighbors of the current node
        if graph[cur_node]:  
            for neighbor, edge_prob in graph[cur_node]:
                # Calculate the new probability for the neighbor by multiplying the current probability with the edge probability
                new_prob = -cur_prob * edge_prob

                # If the new probability is greater than the previously stored one, update it
                if new_prob > max_prob[neighbor]:
                  
                    # Update the probability for the neighbor
                    max_prob[neighbor] = new_prob
                    
                    # Push the neighbor into the queue with the new probability
                    heapq.heappush(pq, (-new_prob, neighbor))
                    
            # Clear the current node's list of neighbors to prevent revisiting it 
            # to ensure we don't revisit nodes we've already processed
            graph[
                cur_node
            ].clear() 
            
    # If there's no valid path from start to end, return 0.0 (no probability)
    return 0.0
    
# Driver code
def main():
    test_cases = [
        (3, [[0, 1], [1, 2], [0, 2]], [0.5, 0.5, 0.2], 0, 2),  
        (3, [[0, 1], [1, 2], [0, 2]], [0.5, 0.5, 0.3], 0, 2),  
        (4, [[0, 1], [1, 2], [2, 3], [0, 3]], [0.5, 0.6, 0.7, 0.2], 0, 3),  
        (5, [[0, 1], [1, 2], [2, 3], [3, 4]], [0.8, 0.6, 0.7, 0.9], 0, 4),  
        (2, [[0, 1]], [0.1], 0, 1),  
        (3, [[0, 1], [1, 2]], [0.5, 0.0], 0, 2)  
    ]

    for i, (n, edges, succProb, start, end) in enumerate(test_cases):
        print(f"{i + 1}.\tNumber of nodes: {n}")
        print(f"\tEdges: {edges}")
        print(f"\tSuccess Probabilities: {succProb}")
        print(f"\tStart: {start}, End: {end}")

        result = max_probability(n, edges, succProb, start, end)
        print(f"\n\tOutput: {result}\n" + "-" * 100)

if __name__ == "__main__":
    main()
