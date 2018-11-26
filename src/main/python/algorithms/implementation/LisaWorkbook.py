import os
import random
import re
import sys
import math

# Complete the workbook function below.


def workbook(n, k, arr):
    for i in range(0, n):
        # print(i)
        counter = 0
        workbooks = math.ceil(float(float(arr[i]/(k*1.0))))
        print("arr[i]: {} and workbooks for it: {}".format(arr[i], workbooks))
        box = 0
        for j in range(1, int(workbooks)):
            start = box * k
            end = (box+1) * k
            print("start {} end {}".format(start, end))
            box += 1
            if box in squere:
                counter += 1


n = 5
k = 3
arr = [4, 2, 6, 1, 10]

workbook(n, k, arr)
