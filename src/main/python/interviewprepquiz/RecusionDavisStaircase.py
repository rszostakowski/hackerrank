def stepPerms(n):
    # https://medium.com/@edwinyung/using-fibonacci-to-exemplify-recursion-big-o-and-memoization-9b1b47316c5e
    if n < 1:
        return 0
    if n == 1:
        return 1
    if n == 2:
        return 1 
    if n == 3:
        return 4 
    return stepPerms(n-3) + stepPerms(n-2) + stepPerms(n-1)

# print(stepPerms(1))
# print(stepPerms(2))
# print(stepPerms(3))
print(stepPerms(5))
