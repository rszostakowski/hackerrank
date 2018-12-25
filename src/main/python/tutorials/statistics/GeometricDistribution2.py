import math

def geo_prob(p1, p2, n):
    return math.pow(p2,n-1)*p1 

def calc_prob(p,q,n):
    print("p {} q {} n {}".format(p, q, n))
    p1 = float(p)/q
    p2 = 1 - p1
    print("p1 {} p2 {}".format(p1, p2))
    return sum([ geo_prob(p1,p2,i) for i in range(1,n+1)])

print(calc_prob(1, 3, 5))
