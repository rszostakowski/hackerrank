def calculate_iqr(x_arr, freq_arr):
    pass

def read_quartiles(int_arr):
    int_arr = sorted(int_arr)
    print(read_quantile(int_arr, 0.25))
    print(read_quantile(int_arr, 0.5))
    print(read_quantile(int_arr, 0.75))

def read_quantile(int_arr, qunatile):
    n = len(int_arr)
    fraction, integer = math.modf(n*qunatile)
    # print("fraction {} integer {}".format(fraction, integer))
    if fraction < 0.5:
        lower = int_arr[int(integer-1)]
        upper = int_arr[int(integer)]
        return int((lower + upper)/2)
    elif fraction == 0.5:
        return int_arr[int(integer)]
    else: 
        lower = int_arr[int(integer)]
        upper = int_arr[int(integer+1)]
        return int((lower + upper)/2)


x_arr = []
freq_arr = []
calculate_iqr(x_arr, freq_arr)
