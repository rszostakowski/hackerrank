
def gridChallenge(grid):
    print(grid)
    if checkRows(grid) and checkColms(grid):
        return "YES"

    return "NO"


def checkRows(grid):
    # TODO 
   return True


def checkColms(grid):
    for i in range(0, len(grid[0])):
        col = column(grid, i)
        print(col)
        if isNotOrdered(col):
            return False 
    return True 

def isNotOrdered(col):
    # TODO
    return False

def column(matrix, i):
    return [row[i] for row in matrix]

grid = ['abc', 'lmp', 'qrt']
print(gridChallenge(grid))

grid =  ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
print(gridChallenge(grid))
