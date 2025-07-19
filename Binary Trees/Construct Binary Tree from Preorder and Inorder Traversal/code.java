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
    HashMap<Integer,Integer>hm=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        return construct(inorder,preorder,0,n-1,0,n-1);
    }
    TreeNode construct(int[] inorder,int[] preorder,int isi,int iei,int psi,int pei){
        if(isi>iei || psi>pei) return null;
        TreeNode root=new TreeNode(preorder[psi]);
        int ridx=hm.get(root.val);
        root.left=construct(inorder,preorder,isi,ridx-1,psi+1,psi+(ridx-isi));
        root.right=construct(inorder,preorder,ridx+1,iei,psi+(ridx-isi)+1,pei);
        return root;
    }
}