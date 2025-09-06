# Definition for a binary tree node
# class TreeNode:
#     def __init__(self, data):
#         self.data = data
#         self.left = None
#         self.right = None

from ds_v1.BinaryTree.BinaryTree import TreeNode
from collections import deque


def is_symmetric(root):
    if not root:
      return True
    
    queue = deque([(root.left, root.right)])
    
    while queue:
        t1, t2 = queue.popleft()
    
        if not t1 and not t2:
            continue
        if not t1 or not t2 or t1.data != t2.data:
            return False
    
        queue.append((t1.left, t2.right))
        queue.append((t1.right, t2.left))
    
    return True

