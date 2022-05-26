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
        /*
        if(root==null)
        {
            return new TreeNode(val);
        }
        else if(root.val > val)
        {
            root.left = insertIntoBST(root.left, val);
        }
        else if(root.val < val)
        {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
        */
    }
}

// so the concept is pretty simple...we have to insert item following the conditions of BST i.e if element greater than root insert in right if smaller insert in left
//and if same then do nothing but as written there are no repetetive elements but still if present then it will not fall in any if conditions 
// and so will simply return curr which is written at the last of code...curr which is the root of the whole tree
// so first what we need to do is store the root in curr var...as in the end after doing all operations we need to return the root of whole tree
// so as its recursive so we cant store root in curr without any condition inside function as then for each recursive call the value of curr will keep updating
// hence we defined curr and one another var level outside function in the class...and intialized both as 0...
// so what we do intially for the first call level is 0 so we check in if condition if level 0 then store root in curr...this way
// in the 1st call obviously root will be the topmost root node of tree and that got stored in curr...and now for each recursive calls level
// would be incremented as level++ done in each else if condition..so level wont be 0 again hence no updation of curr will happen..the root will be stored there safely
// now if root == null i.e empty tree in that condition whatever value has to be inserted will be the only node and hence the root node of the tree...so return ins
// ins is the node we created for the given value to be inserted
// else if root.val > val we will go in the left side but here also one extra condition what if that is the leaf node..so we check for root.left=null
// if yes then we insert our node in the left of this node..and after inserting also we can simply return curr there
// or we can leave and let the recursive function call outside if condn for left side happen..in that condition what will happen the function will be called for a node(root.left)
// whose value is equal to val..i.e the val we had to insert as this is that inserted node only which we just inserted in if condition
// so it will not fall under any if else conditions and hence go the last and will return curr..ultimately the same thing which we wanted to return
// same in the case for right calls...thats all..

// the commented code is more simpler one taking care of all the cases as when empty it return the newNode only
// and also in left and right recursions when we reach a leaf node then for that recursive calls falls under null condition so it returns the newNode 
// but when it return as the calls are like root.left = that call or root.right = that call so whatever i.e the newNode that function returns when control comes back then it gets connected to either root.left or right depending on the condition
// nd likewise it backtracks as function calls keeps on finishing so all the connection are remade againa as the funaction call backtracks so in the end we reach root and return root