import math

def calc_prob(mi, sigma, t1, t2):
    print("mi {} sigma {} t1 {} t2 {}".format(mi, sigma, t1, t2))
    print(round(100*(1-cum_dist_func(mi,sigma,80)),2))
    print(round(100*(1-cum_dist_func(mi,sigma,60)),2))
    print(round(100*(cum_dist_func(mi,sigma,60)),2))

def cum_dist_func(mi, sigma, x):
    return 0.5*(1+math.erf((x-mi)/(sigma*math.sqrt(2))))

calc_prob(70,10,80,60)
