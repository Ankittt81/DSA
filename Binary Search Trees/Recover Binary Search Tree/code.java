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
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode sec=null;
    public void recoverTree(TreeNode root) {
       inorder(root);
        if(first!=null && sec!=null){
            int temp=first.val;
            first.val=sec.val;
            sec.val=temp;
        }
      
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val>root.val && first==null){
            first=prev;
            sec=root;
        }
        else if(prev!=null && prev.val>root.val){
            sec=root;
        }
        prev=root;
        inorder(root.right);
    }
}