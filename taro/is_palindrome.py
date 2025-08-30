def is_palindrome(num: int) -> bool:

    if num < 0 or num % 10 == 0 and num != 0:
        return False

    reversed = 0
    while num > reversed:
        reversed = reversed * 10 + num % 10
        num //= 10

    if num == reversed or num == reversed // 10:
        return True

    return False

if __name__ == '__main__':
    print(f'1 -> {is_palindrome(1)}')
    print(f'12 -> {is_palindrome(12)}')
    print(f'121 -> {is_palindrome(121)}')
    print(f'12321 -> {is_palindrome(12321)}')
    print(f'1221 -> {is_palindrome(1221)}')
    print(f'120 -> {is_palindrome(120)}')
    print(f'-1 -> {is_palindrome(-1)}')

