
def checkBST(root):
    path = []
    inOrder(root, path)
    return len(path) == len(set(path)) and path == sorted(path)


def inOrder(root, path):
    if root.left != None:
        inOrder(root.left, path)

    path.append(root.data)

    if root.right != None:
        inOrder(root.right, path)
