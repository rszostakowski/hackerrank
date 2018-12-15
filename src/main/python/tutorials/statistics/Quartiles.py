import math


def read_quartiles(int_arr):
    int_arr = sorted(int_arr)
    print(read_quantile(int_arr, 0.25))
    print(read_quantile(int_arr, 0.5))
    print(read_quantile(int_arr, 0.75))

def read_quantile(int_arr, qunatile):
    n = len(int_arr)
    fraction, integer = math.modf(n*qunatile)
    print("fraction {} integer {}".format(fraction, integer))
    if fraction != 0.5:
        lower = int_arr[int(integer-1)]
        upper = int_arr[int(integer)]
        return((lower+upper)/2)
    else:
        return(int_arr[int(integer)])


x_arr = [3, 7, 8, 5, 12, 14, 21, 13, 18]
read_quartiles(x_arr)
