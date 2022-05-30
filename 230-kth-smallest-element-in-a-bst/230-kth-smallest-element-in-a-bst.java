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
    int count = 0;
    int a;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
        {
            return a;
        }
        //if(root!=null)
        else
        {
            kthSmallest(root.left, k);
            count++;
            if(count==k)
            {
                a = root.val;
                return a;
            }
            kthSmallest(root.right, k);
        }
        return a;
    }
}

// here the concept is simple we have to do inorder traversal as inorder traversal has elements in sorted increasing order..
// so we can get kth index element that will be kth smallest element...
// hence what we do we keep track of index as count...so 1st we go to extreme left as in inorder and increase count for each left traversed
// if count==k then we got there and store that elemnt in a var and return it...else we traverse the right..nd for that right again we will traverse its left 1st