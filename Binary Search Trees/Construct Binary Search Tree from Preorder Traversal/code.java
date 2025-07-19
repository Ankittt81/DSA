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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length<0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        if(preorder.length==0) return root;
        for(int i=1;i<preorder.length;i++){
            insertion(root,preorder[i]);
        }
        return root;
    }
    TreeNode insertion(TreeNode root,int val){
        if(root==null){
            TreeNode nn=new TreeNode(val);
            return nn;
        }
        if(val<root.val) root.left=insertion(root.left,val);
        else root.right=insertion(root.right,val);
        return root;
    }
}