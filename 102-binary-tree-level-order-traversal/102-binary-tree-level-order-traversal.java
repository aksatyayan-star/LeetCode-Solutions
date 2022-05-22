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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        //List<Integer> res = new ArrayList<Integer>();
        if(root == null)
        {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.isEmpty()==false)
        {
            List<Integer> res = new ArrayList<Integer>();
            int count = q.size();
            for(int i=0; i<count; i++)
            {
                TreeNode curr = q.poll();
                // ans.add(level, new ArrayList<>(Arrays.asList(curr.val)));
                res.add(curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            //level++;
            ans.add(res);
        }
        return ans;
    }
}
// so the concept is here to use queue and its fifo prop to get level order traversal
// so 1st we add root to the queue then we run while loop till queue is not empty that is till we traversed all nodes
// so inside while loop 1st we initialize an arraylist to store the elements of one level
// then we get size of queue acc to which our for loop will run iterations...like in base root topmost 3 lets say size of queue is 1
// so for loop will run once...then inside for loop in curr we pop and store the 1st element of queue encountered here it will be 3..
// then that 3 will be added to that res arraylist which was initialized to store elements of one level
// then we check if 3 has left and right elements if yes then those two will be added to queue..in this case 9 and 20 will be added to queue
// then for loop ended and res was added to ans...that is in 2d list as on 1st level only one element 3 was there so 1st list of 2d list will contain only 3
// then again while loop runs as q not empty..it has 9 and 20...so count = 2 and see res got reinitialized again...as we started traversing new level
// as res work is to store elements on one level...so this time for loop will run twice as count 2
// so for 1st iteration q.poll will give 9 and it will be popped out as it is 1st element in queue after 3 was popped in earlier while loop iteration
// 9 will be added to res...then 9's left and right will be added to queue if present...so 1st iteration of for loop completed
// now count 2 so 2nd iteration runs...now q.poll will give 20 as next element to 9 was 20 in queue and 9 got pooped in previous iteration so now 20's chance
// so 20 will be added to res...notice here we are currently at the same level so res didnt get reinitialized...and now res contains both 9 and 20
// then if 20 has right or left elements it will be added to queue that is 15 and 7...and then res's elements will be added to ans
// that is res containing 9 and 20 together as a list will be added to 2d list ans
// now for next while loop iteration again res will be initialized and so on after each level its elements will be added to ans and it will be getting reinitialized again and again
// till last level
// so the concept here is when we are at some level its elemnts get popped out and its children get added correspondingly...again in next iteration child as curr gets popped
// and further its children get added to queue...and what we are doing is that we store that popped element in res...which gives us all the elements at a level in tree
// then we transfer that to ans and again begin traversal of next level when while loop's next iteration starts
// inner loop i.e for loop adds all elements of one level to queue
// and outer level i.e while loop adds that queue to 2d arraylist as an arraylist