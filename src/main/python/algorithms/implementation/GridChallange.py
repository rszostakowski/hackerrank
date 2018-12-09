
def gridChallenge(grid):
    print(grid)
    if checkRows(grid) and checkColms(grid):
        return "YES"

    return "NO"


def checkRows(grid):
   return True 


def checkColms(grid):
   return True 

grid = ['abc', 'lmp', 'qrt']
print(gridChallenge(grid))
