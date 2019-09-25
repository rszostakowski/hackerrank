from collections import Counter

def whatFlavors(cost, money):
    secik = Counter([i for i in cost if i < money])
    print("secik {}".format(secik))
    elem = check(secik, money)


    # print("first {}, second {}".format(elem, money - elem))
    first_idx = cost.index(elem)+1
    cutted = cost[first_idx:]
    second_idx = first_idx + cutted.index(money - elem)+1
    print("{} {}".format(first_idx, second_idx))
 
def check(secik, money):
    for elem in secik.keys():
        print(elem)
        if secik.__contains__(money - elem) and elem == money - elem and secik[elem]>2: 
            return elem
        if secik.__contains__(money - elem) and secik[elem] > 1:
            return elem

    # copied = secik
    # while len(secik) != 0:
    #     elem = secik.
    #     print("checking {} looking for {}".format(elem, money-elem))
    #     print("set {}".format(secik))
    #     if copied.__contains__(money - elem):
    #         print("returning {}".format(elem))
    #         return elem

# whatFlavors([1, 4, 5, 3, 2], 4)
whatFlavors([2,2,3,4], 4)
