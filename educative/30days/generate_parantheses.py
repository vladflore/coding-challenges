def generate_parentheses(n: int) -> list[str]:
    """
    Return all combinations of n pairs of balanced parentheses.
    Example: n=3 -> ["((()))","(()())","(())()","()(())","()()()"]
    """
    results = []

    def backtrack(s: list[str], open_count: int, close_count: int):
        if len(s) == 2 * n:
            results.append(''.join(s))
            return
        if open_count < n:
            s.append('(')
            backtrack(s, open_count + 1, close_count)
            s.pop()
        if close_count < open_count:
            s.append(')')
            backtrack(s, open_count, close_count + 1)
            s.pop()

    backtrack([], 0, 0)
    return results


if __name__ == "__main__":
    for n in range(1, 5):
        combos = generate_parentheses(n)
        print(f"n={n} ({len(combos)}):", combos)

