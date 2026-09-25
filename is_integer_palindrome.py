def is_palindrome(num: int) -> bool:
    if num < 0 or (num % 10 == 0 and num != 0):
        return False

    reversed_half = 0
    while num > reversed_half:
        last_digit = num % 10
        reversed_half = reversed_half * 10 + last_digit
        num //= 10

    return num == reversed_half or num == reversed_half // 10


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('is_palindrome(121)', is_palindrome(121), True),
        check('is_palindrome(-121)', is_palindrome(-121), False),
        check('is_palindrome(10)', is_palindrome(10), False),
        check('is_palindrome(0)', is_palindrome(0), True),
        check('is_palindrome(12321)', is_palindrome(12321), True),
        check('is_palindrome(1234)', is_palindrome(1234), False),
        check('is_palindrome(123321)', is_palindrome(123321), True),
    ]
    print(f"{sum(results)}/{len(results)} passed")
