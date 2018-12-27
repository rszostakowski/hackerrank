
def calc_prob(mi, sigma, t1, t2, t3):
    print("t1 {} t2 {} t3 {}".format(t1, t2, t3))


mi, sigma = list(map(int, input().split(" ")))
t1 = float(input().strip())
t2, t3 = list(map(float, input().split(" ")))
print(calc_prob(mi, sigma, t1, t2, t3))
