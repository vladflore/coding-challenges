class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverse_linked_list(head: ListNode) -> ListNode:
    previous = None
    current = head

    while current:
        next = current.next
        current.next = previous
        previous = current
        current = next
    return previous


def display(head: ListNode) -> None:
    current = head
    while current:
        if current.next:
            print(current.val, end= ' -> ')
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


if __name__ == "__main__":
    results = [
        check('reverse_linked_list([1, 2, 3])', to_list(reverse_linked_list(from_list([1, 2, 3]))), [3, 2, 1]),
        check('reverse_linked_list([1, 2])', to_list(reverse_linked_list(from_list([1, 2]))), [2, 1]),
        check('reverse_linked_list([1])', to_list(reverse_linked_list(from_list([1]))), [1]),
        check('reverse_linked_list([])', to_list(reverse_linked_list(from_list([]))), []),
    ]
    print(f"{sum(results)}/{len(results)} passed")
