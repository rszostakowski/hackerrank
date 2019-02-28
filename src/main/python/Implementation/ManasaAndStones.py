import itertools


def stones(n, a, b):
    print("n {}, a {}, b {}".format(n, a, b))

    my_arr = [a, b]

    s = set()
    print(my_arr)
    for subset in itertools.combinations_with_replacement(my_arr, n-1):
        print(subset)
        s.add(sum(subset))

    print(sorted(s))
# //https://docs.python.org/3/library/itertools.html#itertools.combinationr


# stones(3, 1, 2)
stones(4, 10, 100)
