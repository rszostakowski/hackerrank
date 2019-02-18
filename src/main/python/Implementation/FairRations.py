def fairRations(N, B):
    print(N)
    print(B)

    suma = sum(B)
    if (suma % 2 == 1):
        print("NO")
        return
# find two odds neigbougrs
# find two odds with a even neigbour
    counter = 0
    while True:
        print(B)
        odd_idx, odd_value = find_firt_odd(B)
        if odd_idx == -1:
            print(counter)
            break
        B[odd_idx] = odd_value + 1

        left = B[odd_idx-1]
        if check_if_odd(left):
            print("inreasing left")
            B[odd_idx-1] = B[odd_idx-1] + 1
        elif odd_idx <= len(B) -1:
            # TODO sprawdzic czy index nie jest wiekszy
            print("increasing right")
            B[odd_idx+1] = B[odd_idx+1] + 1
        else:
            B[odd_idx-1] = B[odd_idx-1] + 1
        counter = counter + 2


def find_firt_odd(B):
    for i in range(0, len(B)):
        if B[i] % 2 == 1:
            return i, B[i]

    return -1, -1


def check_if_odd(num):
    if num % 2 == 1:
        return True
    else:
        return False


N = 5
B = [2,3,4,5,6]
fairRations(N, B)
# N = 2
# B = [1, 2]
# fairRations(N, B)
