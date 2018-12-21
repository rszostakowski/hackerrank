import math


def calculate_iqr(x_arr, freq_arr):
    res_arr = []
    idx = 0
    for j in freq_arr:
        for i in range(0, j):
            res_arr.append(x_arr[idx])
        idx = idx+1
    res_arr = sorted(res_arr)
    print(res_arr)

    q1 = read_quantile(res_arr, 0.25)
    q3 = read_quantile(res_arr, 0.75)
    print("q1 {} q3 {}".format(q1, q3))
    return q3-q1


def read_quantile(int_arr, qunatile):
    n = len(int_arr)
    fraction, integer = math.modf(n*qunatile)
    print("fraction {} integer {}".format(fraction, integer))
    if n % 2 == 0: 
        lower = int_arr[int(integer-1)]
        upper = int_arr[int(integer)]
        return int((lower + upper)/2)
    else:
        return int_arr[int(integer)]

x_arr = [6, 12, 8, 10, 20, 16]
freq_arr = [5, 4, 3, 2, 1, 5]
print(calculate_iqr(x_arr, freq_arr))

x_arr = [10, 40, 30, 50, 20]
freq_arr = [1, 2, 3, 4, 5]
print(calculate_iqr(x_arr, freq_arr))
