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
 class pair{
    TreeNode root;
    int idx;
    pair(TreeNode root,int idx){
        this.root=root;
        this.idx=idx;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(root,0));
        int maxwidth=0;
        while(!q.isEmpty()){
            int size=q.size();
            int minidx=q.peek().idx; //for get refernce idx so that all ele in this iteration have idx from 0
            int first=0;
            int last=0;
            for(int i=1;i<=size;i++){
                pair p=q.poll();
                int curridx=p.idx-minidx; //this is for generating idx from 0
                TreeNode node=p.root;
                if(i==1) first=curridx;
                if(i==size) last=curridx;
                if(node.left!=null) q.add(new pair(node.left,2*curridx));
                if(node.right!=null) q.add(new pair(node.right,2*curridx+1));
                maxwidth=Math.max(maxwidth,last-first+1);
            }
        }
        return maxwidth;
    }
}