import math

def calc_prob(n, X, Y):
    ranks_x = calc_ranks(X)
    ranks_y = calc_ranks(Y)
    print(ranks_x)
    print(ranks_y)
    d_arr = [math.pow((ranks_x[i]-ranks_y[i]),2) for i in range(n)]
    d_2 = sum(d_arr)
    r_xy =round(1 - (6*d_2/(n*(math.pow(n,2)-1))),3)
    print(r_xy)


def calc_ranks(X):
    ranks_x = []
    x_sort = sorted(X)[::-1]
    for idx in range(len(X)):
        print(X[idx])
        idx_x = X.index(X[idx])
        idx_sort = x_sort.index(X[idx])
        print("el {} idx_x {} idx_sort {}".format(X[idx], idx_x, idx_sort))
        ranks_x.append(idx_x - idx_sort)
    return ranks_x

n = 10
X = [10.0, 9.8, 8.0, 7.8, 7.7, 1.7, 6.0, 5.0, 1.4, 2.0]
Y = [200.0, 44.0, 32.0, 24.0, 22.0, 17.0, 15.0, 12.0, 8.0, 4.0]
 
calc_prob(n, X, Y)
