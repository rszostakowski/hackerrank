import math

def calc_prob(max_weight, num_of_cargos, cargo_mean_weight, cargo_sigma):
    print("max_weight {}, num_of_cargos {}, cargo_mean_weight {}, cargo_sigma {}".format(max_weight, num_of_cargos, cargo_mean_weight, cargo_sigma))
    print(round(cum_dist_func(num_of_cargos*cargo_mean_weight,
        math.sqrt(num_of_cargos)*cargo_sigma,max_weight),4))


def cum_dist_func(mi, sigma, x):
    return 0.5*(1+math.erf((x-mi)/(sigma*math.sqrt(2))))

calc_prob(9800, 49, 205, 15)
