from collections import deque
import bisect

class MKAverage:
    def __init__(self, m: int, k: int):
        self.m = m
        self.k = k
        self.stream = deque()
        self.sorted_window = []

    def addElement(self, num: int) -> None:
        self.stream.append(num)
        bisect.insort(self.sorted_window, num)

        if len(self.stream) > self.m:
            old = self.stream.popleft()
            idx = bisect.bisect_left(self.sorted_window, old)
            self.sorted_window.pop(idx)

    def calculateMKAverage(self) -> int:
        if len(self.stream) < self.m:
            return -1
        trimmed = self.sorted_window[self.k: self.m - self.k]
        return sum(trimmed) // len(trimmed)

