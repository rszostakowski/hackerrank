import math

def calc_prob(sample_size, mi, sig, percentage,z_val):
    print("sample_size {}, mi {}, sig {}, percentage {} z value {}".format(sample_size, mi, sig, percentage, z_val))
    print(mi-sig*(0.98))
    print(mi+sig*0.98)

def cum_dist_func(mi, percentage, x):
    return 0.5*(1+math.erf((x-mi)/(percentage*math.sqrt(2))))

calc_prob(100,500,80,0.95,1.96)
