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
    public boolean isValidBST(TreeNode root) {
        return valid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean valid(TreeNode root,int s,int e){
        if(root==null) return true;
        if(s<=root.val && root.val<=e){
            boolean l=valid(root.left,s,root.val-1);
            if(l==false) return false;
            boolean r=valid(root.right,root.val+1,e);
            if(r==false) return false;
            else return true;
        }
        else return false;
    }
}