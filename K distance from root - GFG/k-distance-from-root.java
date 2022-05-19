// { Driver Code Starts
//Initial Template for Java

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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String X[] = br.readLine().trim().split(" ");
	            int k = Integer.parseInt(X[0]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    ArrayList<Integer> nodes = g.Kdistance(root,k);
			    for(int i = 0;i<nodes.size();i++){
			        System.out.print(nodes.get(i)+ " ");
			    }
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> ans = new ArrayList<Integer>();
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
          if(root==null)
          {
              return ans;
          }
          if(k==0)
          {
              ans.add(root.data);
          }
          else
          {
              Kdistance(root.left,k-1);
              Kdistance(root.right,k-1);
          }
          return ans;
     }
}

// so the concept here is that we have root node and k and we have to print all nodes at k distance from root node
// so it means print all nodes at kth level..assuming k=0 for root node
// hence if root = null then just return the arraylist...if k==0 then we at req level or node add that data to list
// else recursively call the whole function with root's left and right child with k value reduced by 1 as we traversed 1 level down
// we will keep traversing down till k becomes 0 as then we reached our required level...so then add those node's data in the list when k becomes 0
// as when we will reach the req level then k will be 0 so for k=0 function calls it will fall under k=0 case and there ans.add() will work and each data will get added in list