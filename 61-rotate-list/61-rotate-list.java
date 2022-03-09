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
        //     return curr.next;
        // }
        // for(int i=0; i<k; i++)
        // {
        //     while(curr.next.next!=null)
        //     {
        //         curr = curr.next;
        //     }
        //     ListNode ans=new ListNode(curr.next.val);
        //     System.out.println(curr.next);
        //     //ans.next=head;
        //     curr.next.next = head;
        //     System.out.println(curr.next.next.val);
        //     curr.next = null;
        //     // ans.next=curr;
        //     curr = head;
        // }
        int size=0;
        while(curr.next!=null)
        {
            size++;
            curr=curr.next;
        }
        size+=1;
        curr.next=head;
        System.out.println(size);
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