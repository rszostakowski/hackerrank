
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
    board_len = len(board)

    coordinates = []
    for i in range(-(board_len+1),board_len):
        for j in range(-(board_len+1),board_len):
            coordinates.append((i,j))

    print(coordinates)
    for i in coordinates:
        new_x = posr + i[0]        
        new_y = posc + i[1]        

        if new_x >= 0 and new_x < board_len and new_y>= 0 and new_y < board_len and board[new_x][new_y] == 'd':

            print(new_x, new_y)
            return new_x, new_y
    raise Exception("wrong")
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
