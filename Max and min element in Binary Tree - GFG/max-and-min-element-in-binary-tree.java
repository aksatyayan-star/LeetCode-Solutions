// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int mx = obj.findMax(root);
		    int mn = obj.findMin(root);
		    System.out.println(mx+" "+mn);
		}
	}
}// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public static int findMax(Node root){
        //code here
        /*int z;
        if(root==null)
        {
            return 0;
        }
        else if(root.left==null && root.right==null)
        {
            z = root.data;
            return z;
        }
        else if(root.left==null)
        {
            z = root.right.data;
            return z;
        }
        else if(root.right==null)
        {
            z = root.left.data;
            return z;
        }
        else
        {
            findMax(root.left);
            findMax(root.right);
            z = Math.max(root.left.data,root.right.data);
        }
        return z;
        */
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        else
        {
            return Math.max(root.data, Math.max(findMax(root.left),findMax(root.right)));
        }
    }
    public static int findMin(Node root){
        /*int y=0;
        //code here
        if(root==null)
        {
            return 0;
        }
        else if(root.left==null && root.right==null)
        {
            y = root.data;
            return y;
        }
        else
        {
            findMin(root.left);
            findMin(root.right);
            if(root.left!=null && root.right!= null)
            {
            y = Math.min(root.left.data,root.right.data);
            }
        }
        return y;
        */
        if(root==null)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return Math.min(root.data, Math.min(findMin(root.left),findMin(root.right)));
        }
    }
}

//again in recursion we shouldnt think much...like i thought in the commented code section
// just write a simple code and let recursion do the work for you thats all
// here at every function call we are comparing first the roots left and right values and getting max and min of it respectively in both functions
// then we are comapring that with its parents node value and getting the overall max and min value respectively in respective functions
// a diff way could be using some kind of traversals like level order and get the max or min of the final list of elements
// even in preorder postorder or inorder we traverse visit each node and store it in arraylist so after whole traversal we can get the max and min from 
// the elements of arraylist and that will be the max and min element of the tree...as trees elements only are stored in list form there in arraylist