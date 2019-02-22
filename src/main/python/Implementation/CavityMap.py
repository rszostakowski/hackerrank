def cavityMap(grid):
    print(len(grid))
    size = len(grid)
    res = grid
    for i in range(0, size-2):
        first_row = list(str(grid[i]))
        second_row = list(str(grid[i+1]))
        third_row = list(str(grid[i+2]))

        for j in range(0, size-2):
            up = int(first_row[j+1]) if first_row[j+1] is not 'X' else 9
            right = int(second_row[j+2]) if second_row[j+2]is not 'X' else 9
            down = int(third_row[j+1]) if third_row[j+1]is not 'X' else 9
            left = int(second_row[j]) if second_row[j]is not 'X' else 9
            to_check = int(second_row[j+1])
            print("to check {} u {} r {} d {} l {}".format(
                to_check, up, right, down, left))
            if up < to_check and right < to_check and down < to_check and left < to_check:
                second_row[j+1] = 'X'
                to_insert = "".join(second_row)
                res[i+1] = to_insert

    return res


grid = [1112,
        1912,
        1892,
        1234]

print(cavityMap(grid))
