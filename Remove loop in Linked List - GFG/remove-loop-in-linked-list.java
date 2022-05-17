// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            Solution x = new Solution();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node slow=head;
        Node fast=head;
        Node curr=head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                break;
            }
        }
        if(slow!=fast)
        {
            return;
        }
        slow = head;
        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
        /* This case is added if fast and slow pointer meet at first position. */
        // as in that condition it would be a circular linked list so we are moving fast till its next = slow 
        // and when we reach fast.next = slow we break that loop by fast.next = null
        else {
            while(fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }
}

// what is being done here is that we are using floyd's loop detection algorithm..where we maintain two pointers 
// fast and slow ...we move slow by one node at a time and fast by two nodes at a time
// by this way acc to this loop detection algo if there is a loop then at some node at some point of time slow and fast will surely meet
// hence we check if slow = fast then its confirmed loop is there and we break out of loop else we return empty
// now once loop is conformed acc to this detection algo if we keep fast at the meeting point ..ie where slow and fast met
// and reinitialize slow to head and move both pointers one node at a time by cheking condition that slow.next not equal to fast.next
// the concept is that the second meeting point(1st meeting point was where we concluded that loop is present) of slow and fast in this condition would be where the loop starts...ie first node of the loop
// and where we get slow.next = fast.next it means wrt to slow the slow.next node is the node from where the loop starts i.e loop is connected there
// and wrt fast the fast.next is the node from where the loop is generated  i.e the connection bcz of which loop exists
// so make fast.next = null and break the loop