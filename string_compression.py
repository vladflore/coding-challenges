class Solution:
    def compress(self, chars: list[str]) -> int:
        read, write = 0, 0
        while read < len(chars):
            char = chars[read]
            count = 0
            while read < len(chars) and chars[read] == char:
                read += 1
                count += 1
            chars[write] = char
            write += 1
            if count > 1:
                for digit in str(count):
                    chars[write] = digit
                    write += 1
        return write


if __name__ == "__main__":
    chars = ["a", "a", "b", "b", "c", "c", "c"]
    result = Solution().compress(chars)
    print(result)
    print(chars[:result])

    chars = ["a"]
    result = Solution().compress(chars)
    print(result)
    print(chars[:result])

    chars = ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"]
    result = Solution().compress(chars)
    print(result)
    print(chars[:result])
