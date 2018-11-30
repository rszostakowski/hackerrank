def flatlandSpaceStations(n, c):
    print("n {} c {}".format(n, c))
    if n == len(c):
        return 0
    min_el = min(c)
    max_el = max(c)
    max_dist = 0
    for i in range(0, n):
        tmp = min(abs(i-min),abs(max_el-i))
        if tmp > max_dist:
            max_dist=tmp
    return max_dist


n=6
c=[0, 1, 2, 4, 3, 5]
flatlandSpaceStations(n, c)

n=5
c=[0, 4]
flatlandSpaceStations(n, c)
