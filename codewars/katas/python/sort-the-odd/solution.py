def sort_array(source_array):
    """
    You have an array of numbers.
    Your task is to sort ascending odd numbers but even numbers must be on their places.

    Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.

    Example

    sort_array([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
    """
    odds = [number for number in source_array if is_odd(number)]
    odds.sort()
    i = -1
    for idx, number in enumerate(source_array):
        if is_odd(number):
            i += 1
            source_array[idx] = odds[i]
    return source_array


# def sort_array1(source_array):
#     odds = sorted((n for n in source_array if is_odd(n)), reverse=True)
#     return [n if not is_odd(n) else odds.pop() for n in source_array]


def is_odd(number):
    return number % 2 != 0


print(sort_array([]))
print(sort_array([5, 3, 2, 8, 1, 4]))

# print(sort_array1([]))
# print(sort_array1([5, 3, 2, 8, 1, 4]))
