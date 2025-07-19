Given a Binary Tree with all unique values and two nodes value, n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may assume that either both n1 and n2 are present in the tree or none of them are present.

LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of tree.

Examples:

Input: root = [1,2,3,4,5,6,7], n1 = 5 , n2 = 6

      
Output: 1
Explanation: LCA of 5 and 6 is 1.
Input: root = [5, 2, N, 3, 4], n1 = 3 , n2 = 4 

           5    
          /    
         2  
        / \  
       3   4
Output: 2
Explanation: LCA of 3 and 4 is 2. 
Input: root = [5, 2, N, 3, 4], n1 = 5 , n2 = 4 

           5    
          /    
         2  
        / \  
       3   4
Output: 5
Explanation: LCA of 5 and 4 is 5. 
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)