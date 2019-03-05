def strangeCounter(t): 
    right = 3
    my_sum = 0
    while True:
        my_sum = my_sum + right
        right *= 2
        if right > t:
            break
    left = my_sum - right/2 + 1
    right = right/2
    print("my_sum {}".format(my_sum)) 
    print("right {}".format(right)) # this the counter down 
    print("left {}".format(left))

    return right - (t-left)


print(strangeCounter(4))
print(strangeCounter(17))
