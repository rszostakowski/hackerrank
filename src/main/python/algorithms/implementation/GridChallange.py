
def gridChallenge(grid):
    grid = sort(grid)
    if checkRows(grid) and checkColms(grid):
        return "YES"

    return "NO"

def sort(grid):
    new_grid = []
    for i in range(0, len(grid[0])):
        sorted_row = sorted(grid[i])
        new_grid.append(sorted_row)
    return new_grid


def checkRows(grid):
    for i in range(0, len(grid[0])):
        sorted_row = sorted(grid[i])
        if isNotOrdered(sorted_row):
            return False
    return True


def checkColms(grid):
    for i in range(0, len(grid[0])):
        col = column(grid, i)
        if isNotOrdered(col):
            return False
    return True


def isNotOrdered(col):
    print("Col : {}".format(col))
    isSorted = all(col[i] <= col[i+1] for i in range(len(col)-1))
    print("isSorted {}".format(isSorted))
    return not isSorted


def column(matrix, i):
    return [row[i] for row in matrix]

# grid = ['abc', 'lmp', 'qrt']
# print(gridChallenge(grid))


grid = ['kc', 'iu']
print(gridChallenge(grid))

# grid =  ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
# print(gridChallenge(grid))
