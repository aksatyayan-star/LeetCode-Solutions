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
    int heightl = 1;
    int heightr = 1;
    int a = 2;
    public int countNodes(TreeNode root) {
        TreeNode currl = root;
        TreeNode currr = root;
        if(root==null)
        {
            return 0;
        }
        if(currl.left!=null)
        {
            leftHeight(currl.left);
        }
        if(currr.right!=null)
        {
            rightHeight(currr.right);
        }
        /* while(currl.left!=null)
        {
            heightl++;
            currl = currl.left;
        }
        
        while(currr.right!=null)
        {
            heightr++;
            currr = currr.right;
        }
        */
        if(heightl==1 && heightr==1)
        {
            return 1;
        }
        if(heightl==heightr)
        {
            return (int) Math.pow(a,heightl)-1;
        }
        else
        {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    int leftHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            heightl++;
            leftHeight(root.left);
        }
        return heightl;
    }
    int rightHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            heightr++;
            rightHeight(root.right);
        }
        return heightr;
    }
}

// the concept is like that we first have to check that whether this given complete binary tree is full binary tree also...i.e even the last level is totally filled
// as in that condition no of nodes will be 2^n -1 where n is the level assuming root node as level 0
// hence to check that its full binary tree or not given its a complete binary tree i.e (in last level elements are filled from left to right)
// so the shortcut or simple way to check is check the extreme left path height and extreme right path height from a node...if both same 
// then full binary tree..as complete given so last level left to right and diretly checking extreme right if that also equal to left it means the whole last level full
// so full simply return 2^height - 1 that will the total no of nodes...so for checking left and right height i have defined two diff functions
// and store left and right height values in integer heightl and heightr...and finally check in main function if both equal then return 2^height -1 
// extra condition to check when both height = 0 ..in that condition only root node there..so simply return 1
//else recursilvely call for that root node's left subtree and right subtree whatever value we will get from those two add 1...it will give total nodes
// as that 1 for the root node whose left and right child we recursively called for...that root node also needs to be added..right

// here in place of writing two extra function to get leftheight and rightheight we could use simple while loop also