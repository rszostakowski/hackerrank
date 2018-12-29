import math
robert 
kasia
def calc_prob(mi, sigma, t1, t2):
    print("mi {} sigma {} t1 {} t2 {}".format(mi, sigma, t1, t2))
    print()

def cum_dist_func(mi, sigma, x):
    return round(0.5*(1+math.erf((x-mi)/(sigma*math.sqrt(2)))),3)


calc_prob(70,10,80,60)
