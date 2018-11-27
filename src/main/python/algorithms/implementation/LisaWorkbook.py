import os
import random
import re
import sys
import math


def workbook(n, k, arr):
    counter = 0
    box = 0
    for i in range(0, n):
        # print(i)
        workbooks = math.ceil(float(float(arr[i]/(k*1.0))))
        print("arr[i]: {} and workbooks for it: {}".format(arr[i], workbooks))
        for j in range(0, int(workbooks)):
            start = j * k
            end = (j+1) * k
            if end > arr[i]:
                end = arr[i]
            box += 1
            print("start {} end {} box: {}".format(start, end, box))
            if box <= end and start <= box:
                counter += 1
    print(counter)


n = 5
k = 3
arr = [4, 2, 6, 1, 10]

workbook(n, k, arr)
