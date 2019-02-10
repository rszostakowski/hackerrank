import collections 

def next_move(posr, posc, board):
    cords, distance = find_closest_dirt(posr, posc, board)
    print("cords {} distance {}".format(cords, distance))
    coma_idx = cords.find(",")
    cord_x = int(cords[0:coma_idx])
    cord_y = int(cords[coma_idx+1:len(cords)])

    dist_x, dist_y = calc_dist(int(posr), int(posc), cord_x, cord_y)

    # print("m_x: {} p_x: {} dist_x {} m_y: {} p_y {} dist_y: {}".format(r, p_x, dist_x, c, p_y, dist_y))
    print("dist_x {} , dist_y {}".format(dist_x, dist_y)) 
    if dist_x == 0 and dist_y == 0:
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

def find_closest_dirt(posr, posc, board):
    board_len = len(board);
    
    d_points = {}
    print("Printing")
    for i in range(0, board_len):
        for j in range(0, board_len):
            el = board[i][j]
            if el == 'd':
                key = "{},{}".format(i,j)
                d1, d2 = calc_dist(posc, posr, i, j) 
                d_points[key] = d1+d2

    print(d_points)
    orderedDict = collections.OrderedDict(sorted(d_points.items(), key=lambda kv: kv[1]))
    return next(iter(orderedDict.items()))

#  (1,0), (1,1), (0,1), (-1,1), (-1,0), (-1,-1), (0,-1), (1,-1)
#  (2,0), (2,1), (2,2), 
# https://stackoverflow.com/questions/464864/how-to-get-all-possible-combinations-of-a-list-s-elements

def calc_dist(m_x, m_y, p_x, p_y):
    # print(type(m_x))
    # print(type(m_y))
    # print(type(p_x))
    # print(type(p_y))
    
    print("m_x {},  m_y {}, p_x {}, p_y {}".format(m_x, m_y, p_x, p_y))
    dist_x=p_y - m_y
    dist_y=p_x - m_x
    return dist_x, dist_y

posr = 0
posc = 0
board = [
        ["b", "-", "-", "-", "d"],
        ["-", "d", "-", "-", "d"],
        ["-", "-", "d", "d", "-"],
        ["-", "-", "d", "-", "-"],
        ["-", "-", "-", "-", "d"]
]

next_move(posr, posc, board)
