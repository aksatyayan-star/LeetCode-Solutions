// { Driver Code Starts
//Initial Template for Java




//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
			    Tree g=new Tree();
                System.out.println(g.isSumProperty(root));
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        int x=0;
        int y=0;
        if(root==null)
        {
            return 1;
        }
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        int sum = 0;
        if(root.left!=null)
        {
            sum = sum+root.left.data;
        }
        if(root.right!=null)
        {
            sum = sum+root.right.data;
        }
        // return (root.data==sum && (isSumProperty(root.left) && isSumProperty(root.right));
        if(root.data==sum)
        {
            x = isSumProperty(root.left);
            y = isSumProperty(root.right);
        }
        return  x & y;
        /*if(x==1 && y==1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
        */
    }
}
// the concept is simple if root = null or leaf node ie. right and left null then return 1..i.e trur
// for rest of the conditions find sum of the nodes children compare it to root node's data...if equal 
// then recursively call for left and right nodes to check for them...i.e is their children sum also equal to parent
// if yes then x and y will get value 1...as if children sum = parent then 1 is being returned in our function
// so finally we return x&y which will be 1 only when both x and y =1 as and operator...nd thats what we need
// we need for every node children sum = parent condition satisfy so if all x and y are 1 then only final return will be 1
// else if even for one node that condition doesnt hold then return 0; as automatically if either x or y is zero at some stage
// then x & y will give 0 and once it returned 0 then for previous function calls also like when traversing back in recursion
// i,e in functuion call stacks... one 0 will be passed which also automatically make final result 0 as x & y..even if one 0 whole result 0
