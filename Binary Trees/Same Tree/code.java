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
    boolean flag;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        flag=true;
        check(p,q);
        return flag;
    }
    void check(TreeNode p,TreeNode q){
        if(p==null && q==null) return;
            if(p==null || q==null ||p.val!=q.val){
                flag=false;
                return;
            }
       check(p.left,q.left);
       check(p.right,q.right);

    }
}