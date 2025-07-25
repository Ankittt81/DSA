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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.left==null && root.right==null) return null;
            else if(root.left!=null && root.right==null) return root.left;
            else if(root.right!=null && root.left==null) return root.right;
            else{
                int max=maxi(root.left);
                root.val=max;
                root.left=deleteNode(root.left,max);
            }
        }
        return root;
    }
    int maxi(TreeNode root){
        
        TreeNode curr=root;
        while(curr.right!=null){
            curr=curr.right;
        }
        return curr.val;
    }
}