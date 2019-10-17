def simplifiedChessEngine(whites, blacks, moves):
    print("whites: {}, blacks {}, moves {}".format(whites, blacks, moves))

    black_queen = blacks[0]    
    # print(black_queen)

    for el in whites:
        print(el)

        if (checkIfMate(el, black_queen) == True):
            return "YES"

    return 


def checkIfMate(white_elem, black_queen):
    
    figure_type = white_elem[0]
    if(check_if_the_same_line(white_elem, black_queen)):
        print("MATCH 2")
    if(figure_type == "Q"):
        pass
    if(figure_type == "N"):
        pass
    if(figure_type == "B"):
        pass
    if(figure_type == "R"):
# check if on the same line
# check if nothing stays on the line
        pass
    
    return False

def check_if_the_same_line(white_elem, black_queen):
#  check vertical line   
    if (white_elem[1] == black_queen[1]):
        print("MATCH VER")
        return True

# check horizontal line
    if (white_elem[2] == black_queen[2]):
        print("MATCH HOR")
        return True

    return False

whites = [['N', 'B', '2'], ['Q', 'B', '1']]
blacks = [['Q', 'A', '4']]
moves = 1

simplifiedChessEngine(whites, blacks, moves)
