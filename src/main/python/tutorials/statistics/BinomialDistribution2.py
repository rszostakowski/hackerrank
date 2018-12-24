import math

def calc_prob(p, n):
    p = float(p)/100
    q = 1 - p
    print("p {} q {}".format(p, q))
    cum_prob = 0
    for i in range(0, 3):
        cum_prob = cum_prob + calc_binomial_distr(i, 10, p) 
    print(round(cum_prob,3))
    cum_prob = 0
    for i in range(0, 2):
        cum_prob = cum_prob + calc_binomial_distr(i, 10, p) 
    print(round(1-cum_prob, 3))


def calc_binomial_distr(x, n, p):
    return calc_combinations(n, x) * math.pow(p, x) * math.pow((1-p),n-x)


def calc_combinations(n, x):
    return math.factorial(n)/(math.factorial(x)*math.factorial(n-x))


calc_prob(12, 10)
