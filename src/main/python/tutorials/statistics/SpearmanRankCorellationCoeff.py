import math


def calc_prob(n, X, Y):
    ranks_x = calc_ranks(X)
    ranks_y = calc_ranks(Y)
    d_arr = [math.pow((ranks_x[i]-ranks_y[i]),2) for i in range(n)]
    d_2 = sum(d_arr)
    print(d_2)


def calc_ranks(X):
    X = map(float, X)
    print(X)
    ranks_x = []
    return sorted(X)


n = 10
X = [10.0, 9.8, 8.0, 7.8, 7.7, 7.0, 6.0, 5.0, 4.0, 2.0]
Y = [200.0, 44.0, 32.0, 24.0, 22.0, 17.0, 15.0, 12.0, 8.0, 4.0]

calc_prob(n, X, Y)
