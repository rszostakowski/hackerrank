class Node(object):
    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next = next_node


def has_cycle(head):
    prev = None
    while(head != None):
        # https://docs.python.org/2/library/sets.html try to use Set
        print("head data {} next {}".format(head.data,head.next))
        prev = head
        head = head.next
        print("prev data {} next {}".format(prev.data, prev.next))
        print("heard data {} next {}".format(head.data, head.next))
        if prev.data > head.data:
            print("True")
            return True
    print("False")
    return False


fourth = Node(4, None)
third = Node(5, fourth)
second = Node(8, third)
first = Node(6, second)

print(has_cycle(first))
