def displayPathtoPrincess(n, grid):
    m_x = int(round(float(n)/2))
    m_y = m_x

    p_x, p_y = index_2d(grid, "p")

    count = 0
    while ((m_x != p_x or m_y != p_y) and count < 10):
        dist_x, dist_y = calc_dist(m_x, m_y, p_x, p_y)
        # print("m_x: {} p_x: {} dist_x {} m_y: {} p_y {} dist_y: {}".format(m_x, p_x, dist_x, m_y, p_y, dist_y))
        if abs(dist_x) >= abs(dist_y):
            if dist_x > 0:
                print("RIGHT")
                m_x=m_x + 1
            else:
                print("LEFT")
                m_x=m_x - 1
        else:
            if dist_y > 0:
                print("DOWN")
                m_y=m_y + 1
            else:
                print("UP")
                m_y=m_y - 1

        count=count + 1

def calc_dist(m_x, m_y, p_x, p_y):
    dist_x=p_x - m_x
    dist_y=p_y - m_y
    return dist_x, dist_y

def index_2d(data, search):
    for i, e in enumerate(data):
        try:
            return i+1, e.index(search)+1
        except ValueError:
            pass
    raise ValueError("{} is not in list".format(repr(search)))
n=3
grid=[["-", "-", "-"], ["-", "m", "-"], ["-", "-", "p"]]
displayPathtoPrincess(n, grid)
grid=[["p", "-", "-"], ["-", "m", "-"], ["-", "-", "-"]]
displayPathtoPrincess(n, grid)
