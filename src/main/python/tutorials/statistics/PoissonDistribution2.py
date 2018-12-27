import math


def calc_prob(lam_a, lam_b):
    print("lam_a {} lam_b {}".format(lam_a, lam_b))
    exp_a = calc_exp_val_from_poisson_distr(lam_a)
    exp_b = calc_exp_val_from_poisson_distr(lam_b)
    print(round(160 + 40*exp_a, 3))
    print(round(128 + 40*exp_b, 3))


def calc_exp_val_from_poisson_distr(lam):
    return lam ** 2 + lam


calc_prob(0.88, 1.55)
