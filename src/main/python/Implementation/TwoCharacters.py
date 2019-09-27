import itertools

def alternate(s):
    my_set = set(s)
    combs = list(itertools.combinations(my_set, 2))
    max_len = 0
    for comb in combs:
        replaced = ''.join(c for c in s if c == comb[0] or c == comb[1]) 
        if is_correct(replaced):
            if len(replaced) > max_len:
                print("replaced {} max len {}".format(replaced, max_len))
                max_len = len(replaced)    
    return max_len

def is_correct(s):
    for i in range(1, len(s)):
        if s[i] == s[i-1]:
            return False
    return True
# print(alternate("beabeefeab"))
print(alternate("asdcbsdcagfsdbgdfanfghbsfdab"))
