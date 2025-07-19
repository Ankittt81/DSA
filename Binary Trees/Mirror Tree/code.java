/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        invert(node);
    }
    Node invert(Node root){
        if(root==null) return null;
      
       Node left=invert(root.left);
       Node right=invert(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}