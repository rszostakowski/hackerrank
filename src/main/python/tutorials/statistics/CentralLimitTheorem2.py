import math

def calc_prob(tickets, students, mean, sigma):
    print("tickets {}, students {}, mean {}, sigma {}".format(tickets, students, mean, sigma))
    print(round(cum_dist_func(students*mean,
        math.sqrt(students)*sigma,tickets),4))


def cum_dist_func(mi, sigma, x):
    return 0.5*(1+math.erf((x-mi)/(sigma*math.sqrt(2))))

calc_prob(250,100,2.4,2.0)
