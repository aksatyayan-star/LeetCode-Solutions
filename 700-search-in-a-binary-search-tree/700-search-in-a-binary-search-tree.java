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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
        {
            return null;
        }
        if(root.val==val)
        {
            return root;
        }
        if(root.val > val)
        {
            return searchBST(root.left, val);
        }
        if(root.val < val)
        {
            return searchBST(root.right, val);
        }
        return null;
    }
}

// the concept is simple in BST...the elements greater than root lies in right of root and smaller lies on left side
// so simply acc to that case recursively call for left and right side..else if matched with root value return the root ..else null if element not present