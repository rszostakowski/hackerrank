def calculate_std(x_arr):
    n = len(x_arr)
    avg = sum(x_arr)/n
    var = sum([((x-avg) **2) for x in x_arr])
    return round((var/n) ** 0.5,1)

x_arr = [10, 40, 30, 50, 20]
print(calculate_std(x_arr))
