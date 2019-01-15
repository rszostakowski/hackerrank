class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node


def has_cycle(head):
    while(head!= None):
        print("data {} next {}".format(head.data, head.next))
        head = head.next
    

first = Node(11, None)
fourth = Node(4, first)
third = Node(5, fourth)
second = Node(8, third)
first = Node(12, second)

has_cycle(first)
