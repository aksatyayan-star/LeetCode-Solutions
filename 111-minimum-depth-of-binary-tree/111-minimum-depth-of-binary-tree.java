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
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        if(root.right==null)
        {
            return minDepth(root.left)+1;
        }
        if(root.left==null)
        {
            return minDepth(root.right)+1;
        }
        else
        {
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
    }
    /*
    public int depth(TreeNode curr)
    {
        if(curr==null)
        {
            return 0;
        }
        else
        {
            return Math.max(depth(curr.left),depth(curr.right))+1;
        }
    }
    public int ndepth(TreeNode curr)
    {
        if(curr==null)
        {
            return 0;
        }
        else
        {
            return Math.min(ndepth(curr.left),ndepth(curr.right))+1;
        }
    }
    */
}
// or just we dont need to think too much...simply the scenario is that if root == null then return 0 everytime...that will be the base case
// then here we have prob when left is empty or right is empty as then in our min function it will consider left value or right value as 0
// when there is no node in that side and so min of 0 and anything will pick up 0...but here if some side is empty then it doesnt get considered in min
// like if tree is only left skewed then in that case right will be always 0 so our min function will keep on picking 0 as min(left,right) where right 0
// but 0 wont be answer...so or such scenarios what we do we just simply ignore the empty side and traverse the other side
// i.e if left side empty we traverse right side and vice versa...
//here the concept is like we will have to define an another function which is used to get the maxdepth of a binary tree...i defined such depth function here 
// and in main function if root=nul i.e empty tree then simply return null
// if only one sided tree i.e only left side present or only right side present then in that condition whichever side present that side's depth
// will be the min depth of whole binary tree as other side empty...so return //math.max(left,right)+1..when left side empty in that condition it will be depth of right side +1 as max(0,right)+1 = right+1 and vice versa
// and in normal condition when tree is not empty and has both sides..so then what we do is that we pass root's left and right in minDepth function
// which calculates the min depth of both side of tree wrt root node i.e left and right...and then for final min depth we choose min of both side's depth+1
// so its a liitle bit tricky as compared to finding the max depth of a binary tree