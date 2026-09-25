def max_profit(prices):
    if not prices:
        return 0

    min_buy_price = prices[0]
    max_profit = 0

    for price in prices:
        if min_buy_price > price:
            min_buy_price = price
        else:
            profit = price - min_buy_price
            if profit > max_profit:
                max_profit = profit

    return max_profit


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('max_profit([7, 1, 5, 3, 6, 4])', max_profit([7, 1, 5, 3, 6, 4]), 5),
        check('max_profit([7, 6, 4, 3, 1])', max_profit([7, 6, 4, 3, 1]), 0),
        check('max_profit([])', max_profit([]), 0),
        check('max_profit([5])', max_profit([5]), 0),
        check('max_profit([3, 8, 1, 2])', max_profit([3, 8, 1, 2]), 5),
        check('max_profit([2, 4, 1])', max_profit([2, 4, 1]), 2),
    ]
    print(f"{sum(results)}/{len(results)} passed")
