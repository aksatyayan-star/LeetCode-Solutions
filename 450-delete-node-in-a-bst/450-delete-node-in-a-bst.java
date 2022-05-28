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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        {
            return null;
        }
        if(root.val>key)
        {
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key)
        {
            root.right = deleteNode(root.right,key);
        }
        else if(root.val==key)
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else
            {
                TreeNode succ = getSucc(root);
                root.val = succ.val;
                root.right = deleteNode(root.right, succ.val);
            }
            return root;
        }
        return root;
    }
    
    TreeNode getSucc(TreeNode root)
    {
        TreeNode curr = root.right;
        while(curr!=null && curr.left!=null)
        {
            curr = curr.left;
        }
        return curr;
    }
}

// so here in deletion also...first we have to search the given key node to be deleted
// now once got that key...then diff conditions is possible..basically 3
// 1st of that node is leaf node then..simply delete it
// 2nd if only one child then connect that child to deleted node's parent i.e connect the child to its grandparent
// 3rd if two children...then in that condition the deleted node has to be replaced with a node having the closest value to the deleted node
// it can be a node of closest higher value or closest lower value..we can choose to replace deleted node with anyone of these
// closest higher value is inorder successor...the next node that comes next to this deleted node in inorder traversal
// as inorder traversal of BST is sorted in increasing order
// inorder successor is closest higher value that means lowest higher value and that can be found for any node by 1st going to its right
// as we need higher or greater value so go right to the node then we need smallest or closest greater..so in that right side go left left
// till leaf node..that will be closest or lowest higher value...in deleting the node this method works fine...
// but this is not the general method to find inorder successor wont work in every case
// so 1st we search and recursively call for root.left and root.right..once we find then for that root which has to be deleted 
// if root.left==null then return root.right and vice versa...this case will work for both conditions 1 nd 2 ie node to be deleted is leaf or having one child
// lets say 6 has to be deleted..one child node..so for 6 function call would have been for 5's right..
// ie. 5.right = deleteNode(5.right,6)...this call passed 6 as argument to the function as 5.right=6
// as if one child then that child will be returned if root.left empty then right child will be returned else left child...
// acc to our ex 6's left empty so 6's right will be returned..ie 7
// nd as in some recursive call we might have reached this else condition so when root.left or right of node to be deleted is returnded...
// here that recursive call is deleteNode(5.right,6)...bczz of this recursive call we reached else condition part as values matched
// then the previous recursive call from function call stack gets this value as return and whether it be of left or right...
// here 5.right will get this value 7 as 5.right = deleteNode(5.right,6)...deleteNode(5.right,6) returned 7...hence 5.right = 7
// if left then root.left = function call and function call returned the value left or right child so the connection got made with root.left = left or right child returned
// ....acc to our ex 5.right = 7 this connection was made
// hence the middle node already got eliminated hence deleted and connection done between grandparent and child skippping the parent...the node to be deleted
// ...acc to our ex..6 got skipped and connection between 5 ie grandparent and 7 child was made and skipped node was the node that had to be deleted

// nd the same will work for 1st condition also like for leaf node as for leaf node it will lie in either of the condition...basically it will fall in 1st if where root.left = null
// so it will return root.right which will be null for leaf node...so whatever function call was made bczz of which we reached this condition that will get return as null
// hence root.left or root.right whichever called this function the connection will be made for null...ie root.right = null or root.left = null...
// so it automatically means that the leaf node got deleted as the node with which it was earlier connected...
// now that connection is made to null hence the leaf node got deattached hence deleted

// now in that 3rd condition of node having two children to be deleted...we have to replace it with inorder successor...lets say delete 5
// for that acc to our strategy of finding inorder successor we defined a function to find that succcessor for curr node which has to be deleted..for 5 we got successor as 6
// so we get that successor and store it in a node succ...then we replace the root with succ
// by replacing the data..ie.root.val = succ.val..5 became 6...nd 6 remained 6
// now we have to delete the succ...as it got in place of root which had to deleted so the earlier place or node of successor has to be deleted...ie the 6 which remained 6
// for that what we do we call for root.right = function(root.right,succ.val)
// i.e root.right is 6 which remained 6 as root was 5 which had to deleted and its right is 6 and with value = 6 function call made which is equal to succ's value.
// ..it will fall into into if(root.left==null) case nd return its right i.e 7 that connection will be made with root.right i.e 5.right = 7 will be made...
// actually it was 5 earlier now its 6 as we replaced with succ value so 6.right = 7 hence the 6 which remained 6 got skipped hence deleted
            