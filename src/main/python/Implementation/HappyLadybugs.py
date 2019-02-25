from collections import Counter

def happyLadybugs(b):
    print(b)

    if len(b) == 1 and b[0] != "_":
        return "NO"

    colors = Counter(b)
    
    initial_len = len(colors)
    del colors["_"]
    after_del = len(colors)

    if initial_len == after_del:
        if check_if_all_the_same(colors):
            return "YES"
        if already_in_place(b) and check_if_bigger_than_one(colors):
            return "YES"
        else:
            return "NO"

    for key in colors:
        print(key)
        if int(colors[key]) == 1:
            return "NO"     
    return "YES"


def check_if_all_the_same(colors):
    return len(colors) == 1

def check_if_bigger_than_one(colors):
    for key in colors:
        if int(colors[key]) == 1:
            return False
    return True

def already_in_place(b):
    for i in range(1, len(b)-1):
        if b[i-1] != b[i] and b[i] != b[i+1]:
            return False
    return True

# print(happyLadybugs("RBY_YBR"))
# happyLadybugs("X_Y__X")
print(happyLadybugs("__"))
# happyLadybugs("B_RRBR")
