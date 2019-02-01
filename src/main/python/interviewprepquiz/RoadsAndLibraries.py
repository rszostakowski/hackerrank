def roadsAndLibraries(n, c_lib, c_road, cities):
    print("num of cities: {}".format(n))
    print("c_lib {}".format(c_lib))
    print("c_road {}".format(c_road))
    print("cities {}".format(cities))
    
    # https://www.python.org/doc/essays/graphs/
    return 2

n = 3
c_lib =  2
c_road = 1
cities =  [[1, 2], [3, 1], [2, 3]]
roadsAndLibraries(n, c_lib, c_road, cities)

n =  6
cc_li = 2
c_road = 5
cities = [[1, 3], [3, 4], [2, 4], [1, 2], [2, 3], [5, 6]]

roadsAndLibraries(n, c_lib, c_road, cities)
