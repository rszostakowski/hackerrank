import math


def calc_prob(lam, k):
    print("lam {} k {}".format(lam, k))
    return round(math.pow(lam, k)*math.pow(math.e, -lam)/math.factorial(k), 3)


print(calc_prob(2.5, 5))
