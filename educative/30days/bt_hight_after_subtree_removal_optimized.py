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
    children_map = collections.defaultdict(list)
    
    def build_maps(node, parent=None):
        if not node:
            return
        node_map[node.data] = node
        parent_map[node.data] = parent
        if parent:
            children_map[parent.data].append(node.data)
        build_maps(node.left, node)
        build_maps(node.right, node)
    
    build_maps(root)
    
    height_memo = {}
    
    def get_height(node):
        if not node:
            return -1
        if node.data in height_memo:
            return height_memo[node.data]
        
        left_height = get_height(node.left)
        right_height = get_height(node.right)
        height = max(left_height, right_height) + 1
        height_memo[node.data] = height
        return height
    
    get_height(root)
    
    def calculate_height_after_removal(removed_node_value):
        if not root or root.data == removed_node_value:
            return -1
        
        queue = collections.deque([(root, 0)])
        max_height = 0
        
        while queue:
            node, height = queue.popleft()
            if not node or node.data == removed_node_value:
                continue
                
            max_height = max(max_height, height)
            
            if node.left and node.left.data != removed_node_value:
                queue.append((node.left, height + 1))
            if node.right and node.right.data != removed_node_value:
                queue.append((node.right, height + 1))
        
        return max_height
    
    results = []
    for query in queries:
        height = calculate_height_after_removal(query)
        results.append(height)
    
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
