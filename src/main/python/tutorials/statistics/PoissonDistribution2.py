import math


def calc_prob(lam_a, lam_b):
    print("lam_a {} lam_b {}".format(lam_a, lam_b))
    prob_a= poisson_distr( 

def poisson_distr(lam, k):
    return round(math.pow(lam, k)*math.pow(math.e, -lam)/math.factorial(k), 3)

print(calc_prob(0.88, 1.55))
