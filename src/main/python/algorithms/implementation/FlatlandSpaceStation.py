import sys
import math


def flatlandSpaceStations(n, c):
    c = sorted(c)
    if n == len(c):
        return 0

    max_dist = c[0]
    last_el_dist = n -1 - c[len(c)-1]
    if last_el_dist  > max_dist:
        max_dist 

    for i in range(0, len(c)):
        dist = int(math.ceil((c[i]-c[i-1])/2))
        if dist >: max_dist
            max_dist = dist

    return max_dist


# n = 5
# c = [0, 4]
# flatlandSpaceStations(n, c)
#
# n=100
# c=[93, 41, 91, 61, 30, 6, 25, 90, 97]
# res3 = flatlandSpaceStations(n, c)
# print(res3)

# n = 95
# c = [68, 81, 46, 54, 30, 11, 19, 23, 22,
#      12, 38, 91, 48, 75, 26, 86, 29, 83, 62]
# res4 = flatlandSpaceStations(n, c)
# print(res4)


n = 20
c = [1, 6, 10, 11, 13]
res5 = flatlandSpaceStations(n, c)
print(res5)
