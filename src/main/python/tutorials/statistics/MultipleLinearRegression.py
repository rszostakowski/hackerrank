import numpy as np


def calculate_iqr(X, Y, X_test):
    X = np.array(X, float)
    Y = np.transpose(np.array(Y, float))
    X_test = np.array(X_test, float)
    print(X)
    print(Y)
    print(X_test)
    X_trans = np.transpose(X)
    XX_inv = np.linalg.inv(np.matmul(X_trans, X))
    B = np.matmul(np.matmul(XX_inv, X_trans), Y)
    print(B)
    print(np.matmul(X_test, B))


X = [[1, 5, 7], [1, 6, 6], [1, 7, 4], [1, 8, 5], [1, 9, 6]]
Y = [10, 20, 60, 40, 50]
X_test = [[1, 5, 5], [2, 5, 5]]

print(calculate_iqr(X, Y, X_test))
