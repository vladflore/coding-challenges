from ds_v1.BinaryTree.BinaryTree import TreeNode
# Definition for a binary tree node
# class TreeNode:
#     def __init__(self, data):
#         self.data = data
#         self.left = None
#         self.right = None

def diameter_of_binaryTree(root):
    '''
    Given a binary tree, you need to compute the length of the tree’s diameter. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Note: The length of the path between two nodes is represented by the number of edges between them.
    '''
  diameter = 0
  
  def height(node):
    nonlocal diameter
    
    if not node:
      return 0
    
    left_height = height(node.left)
    right_height = height(node.right)
    
    diameter = max(diameter, left_height + right_height)
    
    return 1 + max(left_height, right_height)
  
  height(root)
  
  return diameter

