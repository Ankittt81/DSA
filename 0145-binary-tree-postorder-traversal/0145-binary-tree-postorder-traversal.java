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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Stack<TreeNode> st1=new Stack();
        Stack<TreeNode> st2=new Stack();
        TreeNode curr=root;
        st1.push(curr);
        while(st1.size()>0){
           TreeNode rem=st1.pop();
           st2.push(rem);
           if(rem.left!=null) st1.push(rem.left);
           if(rem.right!=null) st1.push(rem.right);
        }
        List<Integer> ans=new ArrayList<>();
        while(st2.size()>0) ans.add(st2.pop().val);
        return ans;
    }
}