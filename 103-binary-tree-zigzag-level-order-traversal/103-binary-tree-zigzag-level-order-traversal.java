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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //List<Integer> ins = new ArrayList<Integer>();
        ArrayList<List<Integer>> fin = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<Integer> s = new Stack<Integer>();
        boolean reverse = false;
        if(root == null)
        {
            return fin;
        }
        q.add(root);
        //int height = 1;
        while(q.isEmpty()==false)
        {
            List<Integer> ins = new ArrayList<Integer>();
            int size = q.size();
            //TreeNode e = q.poll();
            //ins.add(e.val);
            /*if(height%2==0)
            {
                for(int i=0; i<size; i++)
                {
                    TreeNode e = q.poll();
                    ins.add(e.val);
                    if(e.left!=null)
                    {
                        q.add(e.left);
                    }
                    if(e.right!=null)
                    {
                        q.add(e.right);
                    }
                }
            }
            else
            {
                for(int i=0; i<size; i++)
                {
                    TreeNode e = q.poll();
                    ins.add(e.val);
                    if(e.right!=null)
                    {
                        q.add(e.right);
                    }
                    if(e.left!=null)
                    {
                        q.add(e.left);
                    }
                }
            }
            height++;
            */
            for(int i=0; i<size; i++)
            {
                TreeNode e = q.poll();
                if(reverse)
                {
                    s.push(e.val);
                }
                else
                {
                    ins.add(e.val);
                }
                if(e.left!=null)
                {
                    q.add(e.left);
                }
                if(e.right!=null)
                {
                    q.add(e.right);
                }
            }
            if(reverse)
            {
                while(s.isEmpty()==false)
                {
                    ins.add(s.pop());
                }
            }
            reverse = !reverse;
            fin.add(ins);
        }
        return fin;
    }
}

// so the concept is almost same like level order traversal with just a little bit modification
// here we are also incorprating height or keeping track of which level we are traversing now and acc to it 
// the right to left push to queue or left to right push to queue depends...that's it
// rest all things are same...but this concept wont work everytime...as for [1,2,3,null,null,5] it will return [1],[3,2],[5,4] instead of [1],[3,2],[4,5]
/// hence this code has limitations
// for a better one we have to use stack where the concept is maintain a bool value initially initialized to false...as for root node
// then traverse for that root node in that traversal we will add root to list and pop it from queue and push its right and left to queue...
// then we will go down to reverse function ...there we wont go inside the loop as reverse = false initially for root node ..so for this iteration
// hence we just make reverse=!reverse that is make revrse true for next iteration
// now in next iteration again find q.size run for loop..for that much no of iteration but here diff is that we dont add the element directly to list
// bczz for this level we need to add it right to left so what we do is that we push elements of that level to stack instead to directly adding them to list
// and we again push their children i.e left and right to queue in normal order
// then we go down to reverse function here reverse is true this time as it was set true at the end of previous iteration for root node
// hence will go inside function there what we do we pop elements of stack and now add it to list..this way elements got added in reverse order i.e right to left in the list
// and again we make reverse=!reverse so reverse = false again so that for next iteration for next level 
// elememts get added left to right..i.e in normal way ...directly adding to list without using stack
// so in the queue there is no modification..in queue elements are getting pushed in the same way as it was being pushed in  normal level order traversal
// i.e first left element then right element...but adding it to list there is some modification...for alternate levels we make reverse = true then false
// when we have to add in normal way there we just directly add to list but in alternate levels we first push to stack
// and then add to list using that stack to add elements in reverse order...this way we get answer in spiral or zig zag form