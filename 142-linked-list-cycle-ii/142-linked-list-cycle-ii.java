/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return null;
        }
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
            return null;
        }
        slow = head;
        if(slow!=fast)
        {
            while(slow.next!=fast.next)
            {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.next; 
        }
        else
        {
            return head;
        }
    }
}

//this is the same question as detection loop and removing it type question
// as there according to floyd's two pointer cycle detecion algorithm once cycle is detected then
// again reinitailizing slow to head and leaving fast to the position where slow and fast first met 
// and again moving both pointers one node at a time and checking slow.next = fast.next so 
// the concept is the 2nd time where slow and fast will meet will be the stating node of the loop so return slow.next
// the else part is for when slow=fast=head in that condition it will be circular linked list 
// so just return head
// so just move one pointer till its next point to head then return that pointer's next which will give head
// we cant directly return head as maybe there could be no loop and only 1 element in the list so for countering that condition
// we have to iterate the linked list even in case of circular linked list to get correct output