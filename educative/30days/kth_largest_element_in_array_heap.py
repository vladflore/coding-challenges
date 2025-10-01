import heapq

def find_kth_largest(nums, k):
    heap = []
    for num in nums:
        heapq.headpush(heap, num)
        if len(heap) > k:
            heapq.headpop(heap)
    return heap[0]
