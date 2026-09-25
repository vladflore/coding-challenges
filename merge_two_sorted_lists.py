import copy

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next


def merge(list1: ListNode, list2: ListNode) -> ListNode:
    # list1 = copy.deepcopy(l1)
    # list2 = copy.deepcopy(l2)
    head = ListNode()
    merged = head

    while list1 and list2:
        if list1.val < list2.val:
            merged.next = ListNode(list1.val)
            list1 = list1.next
        else:
            merged.next = ListNode(list2.val)
            list2 = list2.next
        merged = merged.next

    while list1:
        merged.next = ListNode(list1.val)
        merged = merged.next
        list1 = list1.next

    while list2:
        merged.next = ListNode(list2.val)
        merged = merged.next
        list2 = list2.next

    return head.next

def print_list(head: ListNode) -> None:
    current = head
    while current:
        if current.next:
            print(current.val, end = ' -> ')
        else:
            print(current.val, end='')
        current = current.next
    print()


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


def from_list(values):
    head = None
    for value in reversed(values):
        head = ListNode(value, head)
    return head


def to_list(head):
    values = []
    while head:
        values.append(head.val)
        head = head.next
    return values


def inputs_after_merge(values1, values2):
    list1, list2 = from_list(values1), from_list(values2)
    merge(list1, list2)
    return to_list(list1), to_list(list2)


if __name__ == "__main__":
    results = [
        check('merge([1, 2, 4], [1, 3, 4])', to_list(merge(from_list([1, 2, 4]), from_list([1, 3, 4]))), [1, 1, 2, 3, 4, 4]),
        check('merge([], [])', to_list(merge(from_list([]), from_list([]))), []),
        check('merge([], [0])', to_list(merge(from_list([]), from_list([0]))), [0]),
        check('merge([5], [1, 2])', to_list(merge(from_list([5]), from_list([1, 2]))), [1, 2, 5]),
        check('merge() leaves its inputs unchanged', inputs_after_merge([1, 3], [2]), ([1, 3], [2])),
    ]
    print(f"{sum(results)}/{len(results)} passed")
