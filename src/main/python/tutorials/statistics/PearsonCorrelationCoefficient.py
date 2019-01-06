import math 

def calc_prob(n, X, Y):
    mi_x = sum(X)/n
    mi_y = sum(Y)/n
    sig_x =  calculate_std(X)
    sig_y = calculate_std(Y)
    d_2 = round(sum([(X[i]-mi_x)*(Y[i]-mi_y) for i in range(n)])/(n*sig_x*sig_y),5)
    print("mi_x {} mi_y {} sig_x {} sig_y {}".format(mi_x,mi_y, sig_x, sig_y))

def calculate_std(x_arr):
    n = len(x_arr)
    avg = sum(x_arr)/n
    var = sum([((x-avg) **2) for x in x_arr])
    return (var/n) ** 0.5

n = 10
X = [10.0, 9.8, 8.0, 7.8, 7.7, 7.0, 6.0, 5.0, 4.0, 2.0]
Y = [200.0, 44.0, 32.0, 24.0, 22.0, 17.0, 15.0, 12.0, 8.0, 4.0]
calc_prob(n, X, Y)
