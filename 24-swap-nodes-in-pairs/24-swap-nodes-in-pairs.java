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
    public ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        ListNode furth = null;
        ListNode next = null;
        if(curr==null)
        {
            return null;
        }
        if(curr.next==null)
        {
            return curr;
        }
        ListNode res = curr.next;
        while(curr!=null && curr.next!=null)
        {
            furth = curr.next.next;
            next = curr.next;
            next.next = curr;
            if(furth==null)
            {
                curr.next = null;
            }
            else if(furth.next==null)
            {
                curr.next = furth;
            }
            else
            {
                curr.next = furth.next;
            }
            curr = furth;
        }
        return res;
    }
}
// current is 1
// so what im doing here is that im storing current's next to next in furth i.e 3(wrt given example) and current's next in next i.e 2
// then just connect next's next to curr i.e 2 to 1...and checking if furth exist if yes then connect curr's next to furth's next i.e 1 to 4 else make it null
// make curr = furth and again iterate the loop this time with curr = 3 ...in this iteration furth will be null so we make curr's next null
// i.e 3's next as null as we can also see from the output 3 is the last element
// if in some case odd no of elements are present then we have checker that furth.next==null if yeas then just make curr's next 
// i.e curr's connection to that last odd element as one element so no swapping needed just connect it
// and to return the whole list we will hve to keep track of head and head will be the 2nd element of list as we are swapping pair wise
// so store 2nd element in res as res=curr.next and simply return it