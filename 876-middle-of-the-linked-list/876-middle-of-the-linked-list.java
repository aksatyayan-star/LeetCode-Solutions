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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null)
        {
            return null;
        }
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// this is an efficient approach...where in one traversal im finding the middle node
// the naive approach will be count the no of nodes in one traversal then in next traversal run a loop till count/2 and print the middle
// but here im maintaining two pointers slow and fast... slow moves by one node at a time and fast moves by two nodes at a time
// till fast reaches null or fast.next becomes null...stop there..at that time the position of slow will be the middle node
// return slow...it will return all the elements of linked list starting from slow to the end