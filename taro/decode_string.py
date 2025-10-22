def decode_string(string: str) -> str:

    current_number = 0
    current_string = ""
    stack = []

    for char in string:
        if char.isdigit():
            current_number = current_number * 10 + int(char)
        elif char == "[":
            stack.append((current_number, current_string))
            current_number = 0
            current_string = ""
        elif char == "]":
            repeat_count, prev_string = stack.pop()
            current_string = prev_string + current_string * repeat_count
        else:
            current_string += char

        for element in reversed(stack):
            print(element)

        print("-" * 10)

    return current_string

if __name__ == '__main__':
    assert decode_string("3[a]2[bc]") == "aaabcbc"
    assert decode_string("3[a2[c]]") == "accaccacc"
    assert decode_string("2[abc]3[cd]ef") == "abcabccdcdcdef"
    assert decode_string("13[xyz]") == "xyz" * 13
