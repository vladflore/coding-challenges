### Statement

Given two arrays of integers `nums` and `index`. Your task is to create _target_ array under the following rules:

- Initially _target_ array is empty.
- From left to right read `nums[i]` and `index[i]`, insert at index `index[i]` the value `nums[i]` in target array.
- Repeat the previous step until there are no elements to read in `nums` and `index`.

Return the _target_ array.

It is guaranteed that the insertion operations will be valid.

### Solution

The key idea is to iterate through the `nums` and `index` arrays simultaneously, inserting each element from `nums` into the target array at the corresponding position specified by `index`. We can use a simple list to represent the target array and utilize the `add(index, value)` method to place elements at the correct positions.
