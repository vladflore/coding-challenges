def is_palindrome(string: str) -> bool:
    cleaned_string = "".join(c.lower() for c in string if c.isalnum())
    left, right = 0, len(cleaned_string) - 1
    while left < right:
        if cleaned_string[left] != cleaned_string[right]:
            return False
        left += 1
        right -= 1
    return True


if __name__ == "__main__":
    assert is_palindrome("A man, a plan, a canal: Panama")
    assert not is_palindrome("race a car")
    assert is_palindrome("")
    assert is_palindrome("No 'x' in Nixon")
    assert not is_palindrome("Hello, World!")
    assert is_palindrome("12321")
    assert not is_palindrome("12345")
