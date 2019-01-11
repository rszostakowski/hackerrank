import numpy as np

def calculate_iqr(X, Y, X_test):
    X = np.array(X,float)
    Y = np.array(Y,float)
    X_test = np.array(X_test,float)

    pass

def calc_linear_reg(x_arr, y_arr):  
    pass

def get_input_params():
    N, m = list(map(int, input().split(" ")))
    X = []
    Y = []
    X_test = []
    for i in range(m):
        raw = input().strip().split(' ')
        X.append(raw[:m])
        Y.append(raw[m:])
    q = int(input().strip())
    for i in range(q):
        x_arr = input().strip().split(' ')
        X_test.append(x_arr)
    
    return X, Y, X_test

X, Y, X_test = get_input_params()    
print(calculate_iqr(X, Y, X_test))
