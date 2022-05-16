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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode res = curr;
        while(curr!=null && curr.next!=null)
        {
            if(curr.val == curr.next.val)
            {
                curr.next = curr.next.next;
            }
            else
            {
                curr = curr.next;
            }
        }
        return res;
    }
}

//this is a basic question, we are just running while loop till curr!=null and curr.next!=null
// nd we are checking if two consecutive nodes have same value then we do curr.next = curr.next.next
// i.e we break the link with just next node to current and make a link to curr's next to next node
// our curr is still there but curr.next got changed to next.next...
//now again we check that is curr.data same as curr.next(which is next.next as we modified it) data...if yes again same step
// i.e change curr.next = curr.next.next...
//else just change the curr i.e move one node ahead as for that particular curr node's data we checked there is no same data ahead 
//then only we fell into else part to move curr one position ahead to check for next datas