// { Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 
// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node temp = new Node(key);
        Node curr = head1;
        Node ans = null;
        if(curr==null)
        {
            return temp;
        }
        if(head1.data>key)
        {
           temp.next = head1;
           ans = temp;
           return ans;
        }
        while(curr.next!=null && curr.next.data<key)
        {
            curr=curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        ans = head1;
        return ans;
    }
}

// what is the situation here is that in only two conditions head will change if head is empty 
// else the value that we have to insert is less than head...in that condition make the value to be inserted as head
// in other cases go till current's next's data is less than key(value to be inserted)
// then make a link of temp.next to curr.next and curr.next to temp....this way the key got inserted in a sorted manner