def flatlandSpaceStations(n, c):
    print("n {} c {}".format(n, c))
    if n == len(c):
        return 0
    max_dist = 0
    for i in range(0, n):
        min_el, max_el = find_closest(i, c)
        print("min and max {} {}".format(min_el, max_el))
        tmp = min(abs(i-min_el), abs(max_el-i))
        if tmp > max_dist:
            max_dist = tmp
    return max_dist


def find_closest(i, c):
    min_el = c[0]
    max_el = c[len(c)-1] 
    for station in c:
        print("station  {}".format(station))
        if station > min_el and station < i:
            min_el = station
        if station < max_el and station > i:
            max_el = station
        
    return min_el, max_el

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
