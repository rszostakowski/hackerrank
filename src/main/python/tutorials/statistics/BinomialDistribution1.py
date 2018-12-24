import math

def calc_prob(p, q):
    denom = p + q
    p = p/denom
    q = q/denom
    # print("p {} q {}".format(p, q))
    cum_prob = 0
    for i in range(3, 7):
       cum_prob = cum_prob + calc_binomial_distr(i, 6, p) 
    return round(cum_prob, 3)


def calc_binomial_distr(x, n, p):
    return calc_combinations(n, x) * math.pow(p, x) * math.pow((1-p),n-x)


def calc_combinations(n, x):
    return math.factorial(n)/(math.factorial(x)*math.factorial(n-x))


print(calc_prob(1.09, 1))
