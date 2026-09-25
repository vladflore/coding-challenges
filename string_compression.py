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


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


def compressed(chars):
    """Returns (new length, compressed prefix): compress() works in place."""
    length = Solution().compress(chars)
    return length, chars[:length]


if __name__ == "__main__":
    results = [
        check("compress(['a', 'a', 'b', 'b', 'c', 'c', 'c'])", compressed(['a', 'a', 'b', 'b', 'c', 'c', 'c']), (6, ['a', '2', 'b', '2', 'c', '3'])),
        check("compress(['a'])", compressed(['a']), (1, ['a'])),
        check("compress(['a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'])", compressed(['a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']), (4, ['a', 'b', '1', '2'])),
        check("compress(['a', 'b', 'c'])", compressed(['a', 'b', 'c']), (3, ['a', 'b', 'c'])),
    ]
    print(f"{sum(results)}/{len(results)} passed")
