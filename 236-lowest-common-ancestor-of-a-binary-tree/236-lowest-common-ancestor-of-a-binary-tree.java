/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
        if(findPath(root, path1, p)==false || findPath(root, path2, q)==false)
        {
            return null;
        }
        int i;
        for(i=0; i<path1.size() && i<path2.size(); i++)
        {
            if (i+1>path1.size()-1 || i+1>path2.size()-1)
            {
                return path2.get(i);
            }
            if(path1.get(i+1)!=path2.get(i+1))
            {
                return path2.get(i);
            }
        }
        return null;
            /*if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i-1);
        */
    }
    boolean findPath(TreeNode root, ArrayList<TreeNode> x, TreeNode p)
    {
        if(root==null)
        {
            return false;
        }
        x.add(root);
        if(root.val==p.val)
        {
            return true;
        }
        if(findPath(root.left,x,p)||findPath(root.right,x,p))
        {
            return true;
        }
        x.remove(x.size()-1);
        return false;
    }
}

// concept is to build two path arrays of treenode type containing path from root to corresponding given nodes...i.e reference to all nodes in that path 
// then traverse both path arrays and search for the last common element in both arrays that will be the LCA
// for building those path arrays we define another function findpath which add elemnts of the path in the array
// if condition to check findPath(root, path1, p)==false || findPath(root, path2, q)==false is that 
// the function will return false if that particular node is not present in the tree..so even if one of the node is not present then return null
// as LCA can only be for two nodes...for one single node LCA is meaningless
// now if present i.e didnt get into if condition that means nodes present and path stored in path1 and path2 respectively for both nodes
// so traverse both list till the last common element and return it that will be LCA
// one extra condition added to check when the last element of the smallest array among path1 and path2 is common..
//then we cant access i+1 as it will be out of bounds...so return last element
// now coming to findPath function how it is finding the path so the concept is that if path not found i.e node not present then it retuns false else it fills the path and return true
// so in pathFind function when we get to some root first we check if null then return false
// else add that node to arraylist i.e path and then check if that nodes val same as req node's val then simply return true...ie we got path
// else call for its left and right so even if any of its left right returns true..i.e we got that req node in either left or right side 
// then if condition valid nd returns true as or operator in if condition
// else we remove that node from path arraylist as it doesnt lead to our req node...nd return false..this way we get path
// like here even if we get into a wrong direction and keep on adding nodes in the list..but at the end when we reach leaf node in that direction
// and still not find req  node then we will start getting false for root==null and hence with each backtracking function calls from stack all those wrong elements
// that was added in the list will be starting to popped out as each function call will start fininshing its exceution from stack..
// it will stop..from where we need to change the path(direction) to reach the req node

// this problem and concept is also useful in finding distance bw two nodes as that path will pass through LCA of both nodes