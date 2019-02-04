def next_move(posr, posc, board):
    dirt_x, dirt_y = find_closest_dirt(posr, posc, board)
    dist_x, dist_y = calc_dist(posr, posc, dirt_x, dirt_y)

    # print("m_x: {} p_x: {} dist_x {} m_y: {} p_y {} dist_y: {}".format(r, p_x, dist_x, c, p_y, dist_y))

    print(dist_x)
    print(dist_y)
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
    board_len = len(board)
    while i < board_len:
#      look from dirt from nearest   
    return 1,1

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
