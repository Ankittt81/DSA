// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    int count=0;
    int ans=-1;
    public int kthSmallest(Node root, int k) {
        // Write your code here
        inorder(root,k);
        return ans;
        
    }
    void inorder(Node root,int k){
        if(root==null) return;
        if(ans==-1) inorder(root.left,k);
        count+=1;
        if(count==k){
            ans=root.data;
            return;
        }
      if(ans==-1) inorder(root.right,k);
    }
}