import math

def read_quartiles(int_arr):
    n = len(int_arr)
    int_arr = sorted(int_arr)
    print(int_arr[int(math.floor(n*0.25))])
    print(int_arr[n/2])
    print(int_arr[int(math.ceil(n*0.75))])

x_arr = [3, 7, 8, 5, 12, 14, 21, 13, 18]
read_quartiles(x_arr)
