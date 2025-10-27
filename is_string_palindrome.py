def is_palindrome(string: str) -> bool:
    cleaned_string = ''.join(c.lower() for c in string if c.isalnum())
    left, right = 0, len(cleaned_string) - 1
    while left < right:
        if cleaned_string[left] != cleaned_string[right]:
            return False
        left += 1
        right -= 1
    return True

if __name__ == '__main__':
    import sys
    args = sys.argv
    if len(args) < 2:
        raise ValuesError('usage: python is_string_palindrome.py <your_string>')
    string = args[1]
    print(f'{string} {"is" if is_palindrome(string) else "is not"} a palindrome')

