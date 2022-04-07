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
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return null;
        }
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// so here what are we doing is that we are traversing the linked list node by node and reversing the link
// the naive approach would be traverse the linked list and store each element in an arraylist and then copy those elements in reverse order in the linked list
// a better approach is like take curr = head and two other nodes prev nd next as null
// then traverse till curr = null...store next element to curr in next node so that while reversing the link we dont lose the next element to curr
//...and prev in curr.next ie reversing the link...initially it would be 0 in 1st iteartion as prev = null initially
// then make prev = curr and curr = next so that next iteartion can happen on these prev and curr