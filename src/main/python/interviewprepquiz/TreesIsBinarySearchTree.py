
def checkBST(root):
    path = []
    inOrder(root, path)
    print(path)

def inOrder(root, path):
    if root.left != None:
        inOrder(root.left, path)

    path.append(root.data)

    if root.right != None:
        inOrder(root.right, path)
