import numpy

def calc_linear_reg(x_arr, y_arr):
    n = len(x_arr)
    x_sum = sum(x_arr)
    x_avg = x_sum/n
    y_sum = sum(y_arr)
    y_avg = y_sum/n
    x_2_sum = sum([i*2 for i in x_arr])
    xy_sum = numpy.dot(x_arr, y_arr)
    print(xy_sum)
    a = 0.8
    b = 0.1
    return a, b

def calc_lin_req_forecast(a, b, x):
    return a * x + b

x_arr = [95, 85, 80, 70, 60]
y_arr = [85, 95, 70, 65, 70]

a, b = calc_linear_reg(x_arr, y_arr)
print(calc_lin_req_forecast(a, b, 80))
