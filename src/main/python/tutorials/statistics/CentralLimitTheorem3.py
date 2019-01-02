import math

def calc_prob(sample_size, mi, sig, percentage,z_val):
    print("sample_size {}, mi {}, sig {}, percentage {} z value {}".format(sample_size, mi, sig, percentage, z_val))
    lower = mi-sig*1.96
    print(lower)
    upper = mi+sig*1.96
    print(upper)
    print(round(cum_dist_func(sample_size*mi,
        math.sqrt(sample_size)*sig,upper),4))

def cum_dist_func(mi, percentage, x):
    return 0.5*(1+math.erf((x-mi)/(percentage*math.sqrt(2))))

calc_prob(100,500,80,0.95,1.96)
