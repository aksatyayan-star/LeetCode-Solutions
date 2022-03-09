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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode curr2 = head;
        int count = 0;
        if(curr==null)
        {
            return null;
        }
        if(curr.next==null)
        {
            return null;
        }
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        if(count==n)
        {
            return curr2.next;
        }
        ListNode curr1 = head;
        for(int i=0; i<(count-n-1); i++)
        {
            curr1= curr1.next;
        }
        curr1.next = curr1.next.next;
        return curr2;
    }
}


// here what we are doing is that as we have to remove the nth node from the end
// so first take care of the extreme conditions like when list is empty then we have to just return null
// again when there is just only one node then also return null...as in both the conditions after deletion list will become empty
// one more diff tricky kind of extreme comdition is when count equals given n...in that condition it means that we will have to delete the first element that is the head of the list
// so just return (store head in curr2) curr2 i.e head .next 
// in rest of the cases head wont change...so just perform necessary operations and return curr2 where we stored head
// in rest of the cases ...first count all the items in the list by iterating the loop till we find curr.next = null that means we reached the last element
// now run a loop till count-n-1 to get the element whose next element we have to delete...so for doing that just update the link like curr1.next = curr1.next.next
// doing this will skip the element that we had to delete and will make a connection of our element to next to next element skipping the just next one element
// then just return the head i.e curr2