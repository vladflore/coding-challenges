import heapq

class KthLargest:
    def __init__(self, k, nums):
        self.k = k
        self.heap = []
        
        for num in nums:
            self.add(num)

    def add(self, val):
        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
        else:
            if val > self.heap[0]:
                heapq.heappushpop(self.heap, val)
        
        return self.heap[0]
