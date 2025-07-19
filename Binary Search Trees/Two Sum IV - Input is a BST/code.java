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
    List<Integer> ans=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<ans.size();i++){
            int rem=k-ans.get(i);
            if(hs.contains(rem)) return true;
            else hs.add(ans.get(i));
        }
        return false;
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}