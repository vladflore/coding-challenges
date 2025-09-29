def climbing_stairs(number_of_stairs: int) -> int:
    if number_of_stairs <= 2:
        return number_of_stairs

    first_step_ways = 1
    second_step_ways = 2

    for i in range(3, number_of_stairs + 1):
        current_step_ways = first_step_ways + second_step_ways
        first_step_ways = second_step_ways
        second_step_ways = current_step_ways

    return second_step_ways

if __name__ == '__main__':
    print(climbing_stairs(2)) # 2
    print(climbing_stairs(3)) # 3

    
