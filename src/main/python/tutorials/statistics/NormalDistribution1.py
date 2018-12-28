import math


def calc_prob(mi, sigma, t1, t2, t3):
    print("mi {} sigma {} t1 {} t2 {} t3 {}".format(mi, sigma, t1, t2, t3))
    print(cum_dist_func(mi, sigma, t1))
    print(cum_dist_func(mi, sigma, t3)-cum_dist_func(mi, sigma, t2))


def cum_dist_func(mi, sigma, x):
    return round(0.5*(1+erf((x-mi)/(sigma*math.sqrt(2)))),3)

def erf(x):
    return (2/math.sqrt(math.pi))*(math.pow(math.e, -(1/3)*math.pow(x, 3))-math.pow(math.e, 0))

calc_prob(20, 2, 19.5, 20, 22)
