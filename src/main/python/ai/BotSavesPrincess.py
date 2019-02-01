import numpy as np
import math

def displayPathtoPrincess(n,grid):
    print(n)
    gird = np.array(grid)
    print(grid)
    m_x =int(round(float(n)/2))
    m_y = m_x
    print(m_x, m_y)
    p_x, p_y = index_2d(grid, "p")
    print(p_x, p_y)

    while (m_x != p_x and m_y != p_y):
        dist_x, dist_y = calc_dist(m_x, m_y, p_x, p_y)
        print(dist_x, dist_y)
        if math.sqrt(dist_x) >= math.sqrt(dist_y):
            if p_x -m_x > 0:
                print("RIGHT")
                p_x = p_x +1
            else:
                print("LEFT")

        else:
            print("UP")
            print("DOWN")


        m_x = p_x
        m_y = p_y

def calc_dist(m_x, m_y, p_x, p_y):
    return 1,1

def index_2d(data, search):
    for i, e in enumerate(data):
        try:
            return i+1, e.index(search)+1
        except ValueError:
            pass
    raise ValueError("{} is not in list".format(repr(search)))
n = 3
grid = [["-","-","-"],["-","m","-"],["-","-","p"]]
displayPathtoPrincess(n,grid)
