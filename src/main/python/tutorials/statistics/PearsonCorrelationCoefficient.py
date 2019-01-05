import math 

def calc_prob(n, X, Y):
    mi_x = sum(X)/n
    mi_y = sum(Y)/n
    ranks_x = calc_ranks(X)
    ranks_y = calc_ranks(Y)
    d_2 = sum(math.pow([(ranks_x[i]-ranks_y[i]) for i in range(n)],2))

def calc_ranks(X):
    ranks_x = []
    print(sorted(X))
    print(X)

n = 10
X = [10.0, 9.8, 8.0, 7.8, 7.7, 7.0, 6.0, 5.0, 4.0, 2.0]
Y = [200.0, 44.0, 32.0, 24.0, 22.0, 17.0, 15.0, 12.0, 8.0, 4.0]
calc_prob(n, X, Y)
