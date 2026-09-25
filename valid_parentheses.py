def is_valid(string_of_parentheses: str) -> bool:
    stack = []
    map = {
        '(':')',
        '{':'}',
        '[':']'
    }

    for character in string_of_parentheses:
        if character in map:
            stack.append(character)
        elif character in map.values():
            if not stack:
                return False
            top_element = stack.pop() 
            if character != map[top_element]:
                return False

    return not stack


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("is_valid('()')", is_valid('()'), True),
        check("is_valid('()[]{}')", is_valid('()[]{}'), True),
        check("is_valid('(]')", is_valid('(]'), False),
        check("is_valid('([)]')", is_valid('([)]'), False),
        check("is_valid('{[]}')", is_valid('{[]}'), True),
        check("is_valid('')", is_valid(''), True),
        check("is_valid('(')", is_valid('('), False),
        check("is_valid(')')", is_valid(')'), False),
    ]
    print(f"{sum(results)}/{len(results)} passed")
