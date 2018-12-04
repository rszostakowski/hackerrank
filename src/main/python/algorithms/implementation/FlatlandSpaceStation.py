import sys


def flatlandSpaceStations(n, c):
    c = sorted(c)
    print("n {} c {}".format(n, c))
    if n == len(c):
        return 0
    max_dist = 0
    for i in range(0, n):
        min_el, max_el = find_closest_left_right(i, c)
        tmp = min(abs(i-min_el), abs(max_el-i))
        print("i {} min and max {} {} min distance {}".format(
            i, min_el, max_el, tmp))
        if tmp > max_dist:
            max_dist = tmp
    return max_dist


def find_closest_left_right(i, c):
    min_el, max_el = 0
    # TODO binary search python
    first = 0
    last = len(c)-1
    while c[first] <= i and  i <= c[last]:
        midpoint = (first + last)/2
        if i < c[midpoint]:
            last = midpoint - 1 
        else:
            first = midpoint + 1 
    
    return min_el, min_el

# n=6
# c=[0, 1, 2, 4, 3, 5]
# flatlandSpaceStations(n, c)


# n = 5
# c = [0, 4]
# flatlandSpaceStations(n, c)

n=100
c=[93, 41, 91, 61, 30, 6, 25, 90, 97]
res3 = flatlandSpaceStations(n, c)
print(res3)

# n = 95
# c = [68, 81, 46, 54, 30, 11, 19, 23, 22,
#      12, 38, 91, 48, 75, 26, 86, 29, 83, 62]
# res4 = flatlandSpaceStations(n, c)
# print(res4)



