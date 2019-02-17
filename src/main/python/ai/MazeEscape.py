def solve_maze():
    rd = int(input())
    print("id: {}".format(id))
    first =  input().strip()
    second = input().strip()
    third = input().strip()
    print(first)
    print(second)
    print(third)

    upper = first[1]
    left = second[0]
    right = second[2] 
    down = third[1]

    what_was_seen= createMatrix(5+5,5+5)
    # find e in the input
    # allocate to map 
    # make a map larger to allocate the inputs
    # memory of the bot?? how have it
    # saving to file is a solution https://www.hackerrank.com/challenges/maze-escape/forum
    print(what_was_seen)
    
    if upper != '#':
        save_to_file(
        print("UP")
        
    if left != '#':
        print("LEFT")

    if right != '#':
        print("RIGHT")

    if down != '#':
        print("DOWN")

def createMatrix(rowCount, colCount):
    mat = []
    for i in range(rowCount):
        rowList = []
        for j in range(colCount):
            # you need to increment through dataList here, like this:
            rowList.append(" ")
        mat.append(rowList)

    return mat

solve_maze()
