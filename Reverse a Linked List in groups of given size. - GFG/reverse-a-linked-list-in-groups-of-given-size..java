// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node curr = node;
        Node prev = null;
        Node next = null;
        int count =0;
        
        while(curr!=null&&count<k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null)
        {
            Node rest_head=reverse(next,k);
            node.next = rest_head;
        }
        return prev;
    }
}

// so here what we are doing is that the concept is much more similar to normal reversing a linked list but just with some modifications
// like we are running while loop till curr!=null and also till count<k as we have to reverse in groups of size k
// here if linked list has k or more elements then always kth elememt will be the new head after performing all reversing operations
// so first we just reverse the nodes in size of k then after the first batch done we check if we there are more elements present
// by checking next!=null if not null then we recursively call for next batch of elements now after performing this we have to link 
// the previous batch reversed elements with current reversed elements...so during second batch recursive call and implementing of function
// lets say we had 8 elements and k as 4 so in 2nd batch recursive call we will not fall into next!=null condition as during 2nd batch all 8 
// elements would be traversed so next will be null hence that call finishes now control will go to 1st batch function call 
// as 1 line of 1st batch function call was waiting to be exceuted
// ie.  line after recursive function call...node.next = rest_head line
// so that will be executed now rest_head will contain 2nd batch reversed elements just like prev used to contain reversed elements during simple reversing
// and node is the head...ie initial linked list's head and so after revrsing that head will act as tail in the 1st batch of nodes
// so we connect that head's(acting as tail now) next to rest_head which is containg 2nd batch's reversed elements....this way connection is made
// nd finally prev is containing the whole reversed linked list so return prev

