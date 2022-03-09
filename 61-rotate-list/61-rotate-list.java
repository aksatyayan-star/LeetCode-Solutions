/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        
        if(curr==null)
        {
            return null;
        }
        // if(curr.next==null)
        // {
        //    return curr.next;
        // }
        /* for(int i=0; i<k; i++)
        // {
        //     while(curr.next.next!=null)
        //     {
        //         curr = curr.next;
        //     }
        //     ListNode ans=null;
        //     curr.next.next = head;
        //     curr.next = null;
        //     curr = head;
        // }
        // return curr;
        */
        int size=0;
        while(curr.next!=null)
        {
            size++;
            curr=curr.next;
        }
        size+=1;
        curr.next=head;
        ListNode ans=null;
        k=k%size;
        k=size-k;
        while(k>-1)
        {
            
            if(k==0)
            {
                ans=curr.next;
                curr.next=null;
                break;
            }
            curr=curr.next;
            k--;
        }
        return ans;
    }
}

// what we are doing is that 1st making a circular list...by connecting last node with head
// for that we are first running a loop to get the size of the list...to get the tail or last element ...then we connect that tail -> curr.next = head
// make an empty list...then take k = size-k as from that point we have to break the link
// so iterate through the loop till k>0...when k = 0 that means we have to stop at that element and break the link there...so store curr.next i.e list from that curr.next in ans list
// and break the link by doing curr.next = null...and just exit the loop using break