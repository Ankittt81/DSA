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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
       for(int i=0;i<n;i++){
        hm.put(inorder[i],i);
       }
       return construct(inorder,postorder,0,n-1,0,n-1);

    }
TreeNode construct(int[] inorder,int[] postorder,int isi,int iei,int psi,int pei){
    if(isi>iei || psi>pei) return null;
    TreeNode root=new TreeNode(postorder[pei]);
    int ridx=hm.get(root.val);
    int count=ridx-isi;
    root.left=construct(inorder,postorder,isi,ridx-1,psi,psi+count-1);
    root.right=construct(inorder,postorder,ridx+1,iei,psi+count,pei-1);
    return root;
    }
}