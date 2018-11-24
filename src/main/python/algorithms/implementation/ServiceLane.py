!/bin/python3

import math
import os
import random
import re
import sys

def serviceLane(n, cases, width):
    for i in range(0, len(cases)):
        start = cases[i][0]
        end = cases[i][1]
        # return(min(width[start:end]))
        print(min(width[start:end]))

n = 5
width = [2, 3, 2, 3, 2, 3, 3]
cases = [
    [0, 3],
    [4, 6],
    [6, 7],
    [3, 5],
    [0, 7]
]
serviceLane(n, cases, width)
