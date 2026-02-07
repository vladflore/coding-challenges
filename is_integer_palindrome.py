def is_palindrome(num: int) -> bool:
    if num < 0 or (num % 10 == 0 and num != 0):
        return False

    reversed_half = 0
    while num > reversed_half:
        last_digit = num % 10
        reversed_half = reversed_half * 10 + last_digit
        num //= 10

    return num == reversed_half or num == reversed_half // 10


if __name__ == "__main__":
    assert is_palindrome(121)
    assert not is_palindrome(-121)
    assert not is_palindrome(10)
    assert is_palindrome(12321)
    assert is_palindrome(0)
    assert not is_palindrome(1234)
    assert is_palindrome(123321)
