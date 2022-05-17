// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            System.out.println( x.countNodesinLoop(head) );
        }
    }
}
// } Driver Code Ends


/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node slow = head;
        Node fast = head;
        int count = 1;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                break;
            }
        }
        if(slow!=fast)
        {
            return 0;
        }
        while(fast.next!=slow)
        {
            fast = fast.next;
            count++;
        }
        return count;
    }
}

// so this question is just a little bit extension of loop detection question...here 1st we check if there is a loop or not
// by floyd's two pointer approach then if loop there then surely fast and slow would have met somewhere at the node inside the loop
// hence what we do we keep one of two pointers at their location and move another one..one node at a ime till it again reaches the other pointer
// as both are inside the loop so surely keeping one constant and moving another will make another meet the constant one again
// and after how many nodes it met the constant one will give us the length of loop as initially both were at the same node so reaching at same node again
// how many nodes one moving pointer had to travel through will give us the length of loop i.e no of nodes present in the loop