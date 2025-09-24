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

if __name__ == '__main__':
    list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next.next = ListNode(4)

    list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next.next = ListNode(4)

    merged = merge(list1, list2)

    print_list(list1)
    print_list(list2)
    print_list(merged)

