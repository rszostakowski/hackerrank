import math

def encryption(s):
    s = s.replace(" ", "")
    len_s = len(s)
    print("s {} ".format(s))
    print("len_s {} ".format(len_s))
    L = math.sqrt(len_s)
    print(L)
    upper = int(math.ceil(L))
    lower = int(math.floor(L))
    print("lower {} upper {} ".format(lower, upper))
    grid = []
    marker = 0
    while True:
        if marker >= len_s:
            break
        if marker + upper> len_s:
            # print("adding {}".format(s[marker:len_s]))
            grid.append(s[marker:len_s])
            break
        upper_bound = marker + upper 
        # print("marker: {} upper_bound {}".format(marker, upper_bound))
        grid.append(s[marker:upper_bound])
        marker = upper_bound

    print(grid) 
    print(len(grid))
    encrypted = ""
    for i in range(0, len(grid)+1):
        string = "" 
        for j in range(0, len(grid)):
            try:
                letter = grid[j][i]
            except IndexError:
                letter = ""
            string = string + letter
        string = string + " "
        encrypted = encrypted + string
    return encrypted


print(encryption("have a nice day"))
# print(encryption("feedthedog"))
# print(encryption("iffactsdontfittotheorychangethefacts"))
