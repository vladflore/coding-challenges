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


if __name__ == "__main__":
    assert 5 == max_profit([7, 1, 5, 3, 6, 4])
    assert 0 == max_profit([7, 6, 4, 3, 1])
    assert 4 == max_profit([1, 2, 3, 4, 5])
    assert 0 == max_profit([])
