import math


def calc_prob(mi, sigma, t1, t2, t3):
    # print("mi {} sigma {} t1 {} t2 {} t3 {}".format(mi, sigma, t1, t2, t3))
    print(cum_dist_func(mi, sigma, t1))
    result = round(cum_dist_func(mi, sigma, t3)-cum_dist_func(mi, sigma, t2),3)
    print(result)

def cum_dist_func(mi, sigma, x):
    return round(0.5*(1+math.erf((x-mi)/(sigma*math.sqrt(2)))),3)


calc_prob(20, 2, 19.5, 20, 22)
