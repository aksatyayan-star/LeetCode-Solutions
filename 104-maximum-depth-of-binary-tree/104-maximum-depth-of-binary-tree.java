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
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        else
        {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}

// so here first 3 will be passed then 3.left i.e for 9 recursive call will be made 
// for 9...9.left call will be made which is null so return 0...then 9.right call..again that is null 
// so return 0 ...now whole 9 call completed ...max of(9.left,9.right)+1...i.e max(0,0)+1 so will return 1
// 1 will be returned to 3.left call...now 3.right call will be made...i.e for 20
// now for 20...20.left call will be made which will make a call for 15 now for 15...15.left call will be made
// which is null so return 0 same way then 15.right call will be made which is null so again return 0
// finally whole 15 call completed...max of(15.left,15.right)+1 ...i.e max(0,0)+1 will return 1 
// so 1 will be returned for 20.left call....then 20.right call will be made for 7
// and in the same way as 15...for 7 calls will happen and finally 1 will be returned for 20.right call
// then for 20 we have 20.left and 20.right as 1...so max(20.left,20.right)+1 = max(1,1)+1 will return 2
// so 2 will be returned to 3.right call
// now we have 3.left as 1 ...got earlier and 3.right as 2..got now..so max(3.left,3.right)+1
// max(1,2)+1. will give 2+1=3 which is the final result and height or depth of binary tree