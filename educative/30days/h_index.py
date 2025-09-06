def hIndex(citations):
    '''
    You are given an array of integers citations, where each element citations [il represents the number of citations received for the ith publication of a researcher.
Your task is to find the researcher's h-index and return the value of h.
Note: The h-index is defined as the highest number h such that the given researcher has published at least h papers, each of which has been cited at least h times.
Constraints:
• n == citations.length
• 1≤ n ≤ 1000
• 0 ≤ citations [il ≤ 1000
    '''
    citations.sort(reverse=True)
    h = 0
    for i, c in enumerate(citations):
        if c >= i + 1:
            h = i + 1
        else:
            break
    return h
