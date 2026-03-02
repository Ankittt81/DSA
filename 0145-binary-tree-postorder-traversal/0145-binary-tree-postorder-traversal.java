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
        Stack<TreeNode> st=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        TreeNode prev=null;
        while(curr!=null || st.size()>0){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            TreeNode node=st.peek();
            if(node.right!=null && prev!=node.right) curr=node.right;
            else {
                ans.add(node.val);
                prev=st.pop();
            }
        }
        return ans;
    }
}