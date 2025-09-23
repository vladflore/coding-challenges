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


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    display(head)
    display(reverse_linked_list(head))
    
    head = ListNode(1)
    head.next = ListNode(2)
    display(head)
    display(reverse_linked_list(head))

    head = ListNode(1)
    display(head)
    display(reverse_linked_list(head))
