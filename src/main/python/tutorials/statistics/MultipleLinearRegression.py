def calc_linear_reg(x_arr, y_arr):
    n = len(x_arr)
    x_sum = sum(x_arr)
    x_avg = x_sum/n
    y_sum = sum(y_arr)
    y_avg = y_sum/n
    x_2_sum = sum([i**2 for i in x_arr])
    xy_sum = sum([a*b for a,b in zip(x_arr, y_arr)])
    b = (n*xy_sum- x_sum*y_sum)/(n*x_2_sum- x_sum ** 2)
    a = y_avg - b*x_avg
    return a, b

def calc_lin_req_forecast(a, b, x):
    return round(a + x * b,3)

x_arr = [95, 85, 80, 70, 60]
y_arr = [85, 95, 70, 65, 70]

a, b = calc_linear_reg(x_arr, y_arr)
print(calc_lin_req_forecast(a, b, 80))
