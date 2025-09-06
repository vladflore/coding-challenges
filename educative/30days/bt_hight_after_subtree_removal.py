import collections

class TreeNode:
   def __init__(self, data):
       self.data = data
       self.left = None
       self.right = None

def heights_after_queries(root, queries):
    if not root:
        return [0] * len(queries)
    
    node_map = {}
    parent_map = {}
    
    def build_maps(node, parent=None):
        if not node:
            return
        node_map[node.data] = node
        parent_map[node.data] = parent
        build_maps(node.left, node)
        build_maps(node.right, node)
    
    build_maps(root)
    
    def calculate_height(node):
        if not node:
            return -1
        
        left_height = calculate_height(node.left)
        right_height = calculate_height(node.right)
        
        return max(left_height, right_height) + 1
    
    results = []
    
    for query in queries:
        node_to_remove = node_map[query]
        parent = parent_map[query]
        
        original_child = None
        if parent:
            if parent.left == node_to_remove:
                original_child = parent.left
                parent.left = None
            else:
                original_child = parent.right
                parent.right = None
        
        height = calculate_height(root)
        results.append(height)
        
        if parent:
            if original_child == node_to_remove:
                if parent.left is None:
                    parent.left = original_child
                else:
                    parent.right = original_child
    
    return results

if __name__ == '__main__':
    #       1
    #      / \
    #     2   3
    #    / \   \
    #   4   5   6
    
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)
    
    queries = [2, 3, 4]

    result = heights_after_queries(root, queries)
    print(f"Solution: {result}")

    # Query 2 (remove left subtree): height becomes 2 (path 1->3->6)
    # Query 3 (remove right subtree): height becomes 2 (path 1->2->4 or 1->2->5)  
    # Query 4 (remove node 4): height remains 2
