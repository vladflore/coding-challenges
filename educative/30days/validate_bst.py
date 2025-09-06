# Definition for a binary tree node
# class TreeNode:
#     def __init__(self, data):
#         self.data = data
#         self.left = None
#         self.right = None

from ds_v1.BinaryTree.BinaryTree import TreeNode
import math

def validate_bst(root):
    '''
    Given the root of a binary tree, check whether it is a valid binary search tree (BST).

A binary tree is a valid BST if for every node:

The left subtree of a node contains only nodes with keys less than the node’s key.

The right subtree of a node contains only nodes with keys greater than the node’s key.

Both the left and right subtrees are valid BSTs.


    '''
    def validate(node, low = float('-inf'), high = float('+inf')):
        if not node:
            return True
        if not (low < node.data < high):
            return False
        return (
            validate(node.left, low, node.data) and
            validate(node.right, node.data, high)
        )
        
    return validate(root)
