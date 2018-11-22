#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the serviceLane function below.
def serviceLane(n, width, cases):
    print("n is {} cases are {}".format(n,cases))
    for i in range(0, n): 
        start = cases[i][0]
        end = cases[i][1]
        print(min(width[start:end]))

serviceLane(6,1)

