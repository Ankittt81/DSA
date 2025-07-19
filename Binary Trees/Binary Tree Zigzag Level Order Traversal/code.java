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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean leftToright=true;
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> curr=new ArrayList<>();
            for(int i=1;i<=sz;i++){
                if(leftToright){
                    TreeNode rem=q.pollFirst();
                    curr.add(rem.val);
                    if(rem.left!=null) q.addLast(rem.left);
                    if(rem.right!=null) q.addLast(rem.right);
                }
                else{
                    TreeNode rem=q.pollLast();
                    curr.add(rem.val);
                    if(rem.right!=null) q.addFirst(rem.right);
                    if(rem.left!=null) q.addFirst(rem.left);
                }
            }
            leftToright=!leftToright;
            ans.add(curr);
        }
        return ans;
    }
}