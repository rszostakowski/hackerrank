def marsExploration(s):
    print(s)
    counter = 0
    for i in range(1, len(s)/3+1):
        signal = s[3*(i-1):3*i]
        counter += how_many_differ(signal)

    return counter


def how_many_differ(signal):
    counter = 0
    print(signal[0])
    if signal[0] == 'S':
        counter+=1
    if signal[1] == 'O':
        counter+=1
    if signal[2] == 'S':
        counter+=1
    return counter


print(marsExploration("SOSSPSSQSSOR"))
# print(marsExploration("SOSOOSOSOSOSOSSOSOSOSOSOSOS"))
