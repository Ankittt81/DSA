class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
       return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean check(Node root,int s,int e){
        if(root==null) return true;
        if(s<=root.data && root.data<=e){
            boolean l=check(root.left,s,root.data-1);
            if(l==false) return false;
            boolean r=check(root.right,root.data+1,e);
            if(r==false) return false;
            else return true;
        }
        else return false;
    }
}