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
    int level = 0;
    TreeNode curr = new TreeNode(0);
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ins = new TreeNode(val);
        if(level==0)
        {
        curr = root;
        }
        if(root==null)
        {
            return ins;
        }
        else if(root.val > val)
        {
            level++;
            if(root.left==null)
            {
                root.left = ins;
                //return curr;
            }
            return insertIntoBST(root.left, val);
        }
        else if(root.val < val)
        {
            level++;
            if(root.right==null)
            {
                root.right = ins;
                //return curr;
            }
            return insertIntoBST(root.right, val);
        }
        return curr;
    }
}