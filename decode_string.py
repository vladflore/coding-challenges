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

    return current_string


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("decode_string('3[a]2[bc]')", decode_string('3[a]2[bc]'), 'aaabcbc'),
        check("decode_string('3[a2[c]]')", decode_string('3[a2[c]]'), 'accaccacc'),
        check("decode_string('2[abc]3[cd]ef')", decode_string('2[abc]3[cd]ef'), 'abcabccdcdcdef'),
        check("decode_string('13[xyz]')", decode_string('13[xyz]'), 'xyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyz'),
        check("decode_string('abc')", decode_string('abc'), 'abc'),
        check("decode_string('')", decode_string(''), ''),
    ]
    print(f"{sum(results)}/{len(results)} passed")
