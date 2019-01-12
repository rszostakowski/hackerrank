import math

def calc_prob(sample_size, mi, sig, percentage,z_val):
    print("sample_size {}, mi {}, sig {}, percentage {} z value {}".format(sample_size, mi, sig, percentage, z_val))
    lower = mi-sig*z_val/math.sqrt(sample_size)
    print(lower)
    upper = mi+sig*z_val/math.sqrt(sample_size)
    print(upper)
    print("the end")

calc_prob(100,500,80,0.95,1.96)
