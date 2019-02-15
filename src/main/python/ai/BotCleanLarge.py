def next_move(posr, posc, dim_x, dim_y, board):
    cords, distance = find_closest_dirt(posr, posc, board)
    coma_idx = cords.find(",")
    cord_x = int(cords[0:coma_idx])
    cord_y = int(cords[coma_idx+1:len(cords)])

    dist_x, dist_y = calc_dist(int(posr), int(posc), cord_x, cord_y)
    if board[posr][posc] == "d":
        print("CLEAN")
    elif abs(dist_x) >= abs(dist_y):
        if dist_x > 0:
            print("RIGHT")
        else:
            print("LEFT")
    else:
        if dist_y > 0:
            print("DOWN")
        else:
            print("UP")

def find_closest_dirt(posr, posc, dim_x, dim_y, board):
    
    d_points = {}
    for i in range(0, dim_x):
        for j in range(0, dim_y):
            el = board[i][j]
            if el == 'd':
                key = "{},{}".format(i,j)
                d1, d2 = calc_dist(posr, posc, i, j) 
                d_points[key] = abs(d1)+abs(d2)
    orderedDict = collections.OrderedDict(sorted(d_points.items(), key=lambda kv: kv[1]))
    return next(iter(orderedDict.items()))


def calc_dist(m_x, m_y, p_x, p_y):
    dist_x=p_y - m_y
    dist_y=p_x - m_x
    return dist_x, dist_y
