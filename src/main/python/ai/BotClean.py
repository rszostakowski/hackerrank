
def next_move(posr, posc, board):
    dirt_x, dirt_y = find_closest_dirt(posr, posc, board)
    dist_x, dist_y = calc_dist(posr, posc, dirt_x, dirt_y)

    # print("m_x: {} p_x: {} dist_x {} m_y: {} p_y {} dist_y: {}".format(r, p_x, dist_x, c, p_y, dist_y))

    print("dirt_x {} dirt_y {}".format(dirt_x, dirt_y))
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
    sorted_by_value = sorted(d_points.items(), key=lambda kv: kv[1])
    print(sorted_by_value)
    return 1,1
#  (1,0), (1,1), (0,1), (-1,1), (-1,0), (-1,-1), (0,-1), (1,-1)
#  (2,0), (2,1), (2,2), 
# https://stackoverflow.com/questions/464864/how-to-get-all-possible-combinations-of-a-list-s-elements

def calc_dist(m_x, m_y, p_x, p_y):
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

print(next_move(posr, posc, board))
