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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode leftTail = left;
        ListNode rightTail = right;
        
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        
        leftTail.next = right.next;
        rightTail.next = null;
        
        return left.next;
    }
}

// what we are doing is that define two linkedlist...and then traverse the main linked list till last element
// then when we encounter a node whose value less than x we push it to left linkedlist and when greater than or equal to x we push to the right
// and finally link left's next to right and return the left