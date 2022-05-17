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
    public ListNode oddEvenList(ListNode head) {
        int count = 1;
        ListNode curr = head;
        ListNode os=null; ListNode oe=null; ListNode es=null; ListNode ee=null;
        while(curr!=null)
        {
            if(count%2!=0)
            {
                if(os==null)
                {
                    os=curr;
                    oe=os;
                    count++;
                    curr=curr.next;
                }
                else
                {
                    oe.next = curr;
                    oe = oe.next;
                    count++;
                    curr=curr.next;
                }
            }
            else
            {
                if(es==null)
                {
                    es=curr;
                    ee=es;
                    count++;
                    curr=curr.next;
                }
                else
                {
                    ee.next = curr;
                    ee = ee.next;
                    count++;
                    curr=curr.next;
                }
            }
        }
        if(es==null || os==null)
        {
            return head;
        }
        oe.next = es;
        ee.next = null;
        return os;
    }
}

//the concept is pretty much same to segregating even odd nodes of the linked list here we are just doing it by maintaining a count