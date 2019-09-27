def superDigit(n, k):
    if n // 10 == 0:
        print(n)
    else:
        n = digital_root(n)

        if k != 0:
            superDigit(r*k,0)
        else:
            superDigit(r,0)
        
def digital_root(n):
    print("n: {}".format(n))
    x = sum(int(digit) for digit in str(n))
    if x < 10:
        return x
    else:
        return digital_root(x)

        
# superDigit(148, 3)
# superDigit(99, 10000)
