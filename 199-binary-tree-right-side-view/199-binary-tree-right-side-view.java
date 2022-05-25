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
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
        {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if(i==size-1)
                {
                    ans.add(curr.val);
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}

// the concept here is simple we have to print the rightmost elements at each level and if right element not present then print the left element
// so thats what we are doing if root == null then return the arraylist our generic base condition
// if root.right = null then in that 1st cond first add that root's val in the arraylist then traverse root.left...that is its left as right = null
// else just traverse the right subtree but first adding that particular node's val in arraylist then traverse its right subtree
// but this wont work in every case...so a better would be to do using level order traversal just the catch is that 
// instead to pushing all elements of a level into the arraylist..we will just push the last element of that level 
// as that will be the rightmost element...and we can get that last element when the for loop will be at the end index i.e at index q.size()-1  
// as then the last element of that level would have been being traversed and its getting popped and its left and right would have been getting added to queue
// only this if(i==size-1) part is extra new condition rest all same as level order traversal
// as the last element of the queue will only be the rightmost element of that particular level...as we traverse and push element to queue left to right