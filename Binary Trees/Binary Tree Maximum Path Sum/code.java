/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int maxPathSum(TreeNode root) {
        ans=root.val;
        sum(root);
        return ans;
    }
    int sum(TreeNode root){
        if(root==null) return 0;
        int lh=Math.max(sum(root.left),0);
        int rh=Math.max(sum(root.right),0);
       ans=Math.max(ans,lh+rh+root.val); 
       return Math.max(lh,rh)+root.val;
    }
}