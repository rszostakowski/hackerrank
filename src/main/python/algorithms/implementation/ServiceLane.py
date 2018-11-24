#!/bin/python3

import math
import os
import random
import re
import sys


def serviceLane(n, cases, width):
    result = []
    for i in range(0, len(cases)):
        start = cases[i][0]
        end = cases[i][1]
        result.append(min(width[start:(end+1)]))
    print(result)
    return result


n = 5
width = [2, 3, 1, 2, 3, 2, 3, 3]
cases = [
    [0, 3],
    [4, 6],
    [6, 7],
    [3, 5],
    [0, 7]
]
serviceLane(n, cases, width)
print("Second example")
n2 = 5
width2 = [1, 2, 2, 2, 1]
cases2 = [
    [2, 3],
    [1, 4],
    [2, 4],
    [2, 4],
    [2, 3]
]
serviceLane(n2, cases2, width2)
