from collections import Counter

def happyLadybugs(b):
    print(b)
    colors = Counter(b)
    del colors["_"]
    if len(colors) == 0:
        return "NO"
    for key in colors:
        print(key)
        if int(colors[key]) % 2 == 1:
            return "NO"
    return "YES"

# print(happyLadybugs("RBY_YBR"))
# happyLadybugs("X_Y__X")
print(happyLadybugs("__"))
# happyLadybugs("B_RRBR")
