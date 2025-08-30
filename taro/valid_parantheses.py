def is_valid(string_of_parantheses: str) -> bool:
    stack = []
    map = {
        '(':')',
        '{':'}',
        '[':']'
    }

    for character in string_of_parantheses:
        if character in map:
            stack.append(character)
        elif character in map.values():
            if not stack:
                return False
            top_element = stack.pop() 
            if character != map[top_element]:
                return False

    return not stack

if __name__ == '__main__':
    assert is_valid('()')
    assert is_valid('{}')
    assert is_valid('[]')
    assert is_valid('([{}])')
    assert False == is_valid('({[})')
