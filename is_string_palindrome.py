def is_palindrome(string: str) -> bool:
    cleaned_string = "".join(c.lower() for c in string if c.isalnum())
    left, right = 0, len(cleaned_string) - 1
    while left < right:
        if cleaned_string[left] != cleaned_string[right]:
            return False
        left += 1
        right -= 1
    return True


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("is_palindrome('A man, a plan, a canal: Panama')", is_palindrome('A man, a plan, a canal: Panama'), True),
        check("is_palindrome('race a car')", is_palindrome('race a car'), False),
        check("is_palindrome('')", is_palindrome(''), True),
        check('is_palindrome("No \'x\' in Nixon")', is_palindrome("No 'x' in Nixon"), True),
        check("is_palindrome('12321')", is_palindrome('12321'), True),
        check("is_palindrome('12345')", is_palindrome('12345'), False),
    ]
    print(f"{sum(results)}/{len(results)} passed")
