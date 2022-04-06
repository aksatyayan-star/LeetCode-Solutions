// { Driver Code Starts
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) 
    {
        data = d; 
        next = null;
    }
}
	

	
public class LinkedList_Element_From_Last
{
    Node head;  
	Node tail;
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	  
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			int k = sc.nextInt();
			LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
          
		//System.out.println(llist.head.data);
        GfG g = new GfG(); 
		//System.out.println(k);
		System.out.println(g.getNthFromLast(llist.head,k));
		
			t--;
		}
	}
}


	
	// } Driver Code Ends


/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here	
    	if(head == null){
    	    return -1;
    	}
    	Node first = head;
    	for(int i=0; i<n; i++)
    	{
    	    if(first==null)
    	    {
    	        return -1;
    	    }
    	    first=first.next;
    	}
    	Node second = head;
    	while(first!=null)
    	{
    	    second = second.next;
    	    first = first.next;
    	}
    	return second.data;
    }
}
// this is two pointer approach
// the naive approach would be... find the length of linked list by traversing till end node and then
// again run a loop till length - n + 1 and that will put us at the req node and just print its data
// in two pointer approach depending on which numbered node we have to find we keep our two pointers that much number apart
// like if we have to find 2nd element from last then we will keep oir pointers two nodes apart
// if 4th node from the end then keep our first and second pointer 4 nodes apart
// we can also see this from the loop which is getting run till n so that first pointer will be n nodes apart from second node which is head initially
// so by this we got or we set our initial positions of both pointers second at the head and first will be n nodes aprt from second i.e head
// then we will just keep on moving both the pointers simultaneously by one node at a time...till first becomes null..first which was n nodes ahead of second
// so when first becomes null that is the point when our second node will be at the req node...so print second node's data
