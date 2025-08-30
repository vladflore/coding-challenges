def max_profit(prices):
    if not prices:
        return 0

    best_buying_price = prices[0]
    max_profit = 0

    for price in prices:
        if best_buying_price > price:
            best_buying_price = price
        else:
            potential_profit = price - best_buying_price
            if potential_profit > max_profit:
                max_profit = potential_profit

    return max_profit

if __name__ == "__main__":
    assert 5 == max_profit([7,1,5,3,6,4])
    assert 0 == max_profit([7,6,4,3,1])

