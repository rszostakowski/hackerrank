def nextMove(n,r,c,grid):
    p_x, p_y = index_2d(grid, "p")
    dist_x, dist_y = calc_dist(r, c, p_x, p_y)
    print("m_x: {} p_x: {} dist_x {} m_y: {} p_y {} dist_y: {}".format(r, p_x, dist_x, c, p_y, dist_y))
    if abs(dist_x) >= abs(dist_y):
        if dist_x > 0:
            return("RIGHT")
        else:
            return("LEFT")
    else:
        if dist_y > 0:
            return("DOWN")
        else:
            return("UP")


def calc_dist(m_x, m_y, p_x, p_y):
    dist_x=p_y - m_y
    dist_y=p_x - m_x
    return dist_x, dist_y

def index_2d(data, search):
    for i, e in enumerate(data):
        try:
            return i, e.index(search)
        except ValueError:
            pass
    raise ValueError("{} is not in list".format(repr(search)))

n=5
r = 2 
c = 3 
grid=[["-", "-", "-", "-", "-"], ["-", "-", "-", "-", "-"],["p", "-","-", "m", "-"],["-", "-", "-", "-", "-"],["-", "-", "-", "-", "-"]]
print(nextMove(n,r,c,grid))
