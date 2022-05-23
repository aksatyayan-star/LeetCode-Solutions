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
    public boolean isBalanced(TreeNode root) {
       if(heightBalanced(root) == -1)
       {
           return false;
       }
       return true;
    }
    int heightBalanced(TreeNode root)
    {
       if(root==null)
        {
            return 0;
        }
        int lh = heightBalanced(root.left);
        if(lh == -1)
        {
            return -1;
        }
        int rh = heightBalanced(root.right);
        if(rh == -1)
        {
            return -1;
        }
        if(Math.abs(lh-rh)>1)
        {
            return -1;
        }
        else
        {
            return Math.max(lh,rh)+1;
        } 
    }
}

//every function call tells both if a particular subtree is balanced or not and it also returns the height...
// if unbalanced..function returns -1...else it returns height which can be used to check the balance of other level(nodes) of tree
// the else part is the function to get height..how we used to get max height of binary tree max(lh,rh)+1
// nd that lh or rh = -1 condition will be triggered when lh-rh will be greater than 1 for some node as then function will return -1 acc to code
// and hence for its parent like for whose node lh-rh was >1 when the recursive call will backtrack then control will get back to parent 
// and parent will get either lh or rh = -1 as -1 was returned in previous call ...so in that condition also return -1 as tree unbalanced
// this function returns -1 if a subtree is unbalanced else it returns the height of that subtree
// if ever -1 is returned then immediately return false as even if one unbalanced subtree the whole tree is unbalanced..else return true in bool isBalanced function