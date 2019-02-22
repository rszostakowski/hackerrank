def fairRations(N, B):

    suma = sum(B)
    if (suma % 2 == 1):
        return("NO")

    counter = 0
    while True:
        odd_idx, odd_value = find_firt_odd(B)
        if odd_idx == -1:
            return(counter)
        B[odd_idx] = odd_value + 1
        B[odd_idx+1] = B[odd_idx+1] + 1
        counter = counter + 2


def find_firt_odd(B):
    for i in range(0, len(B)):
        if B[i] % 2 == 1:
            return i, B[i]
    return -1, -1

N = 5
B = [2,3,4,5,6]
fairRations(N, B)
