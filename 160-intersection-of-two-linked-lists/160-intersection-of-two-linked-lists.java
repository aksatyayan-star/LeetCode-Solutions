/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0;
        int count2=0;
        ListNode curr1=headA;
        ListNode curr2=headB;
        while(curr1!=null)
        {
            curr1=curr1.next;
            count1++;
        }
        while(curr2!=null)
        {
            curr2=curr2.next;
            count2++;
        }
        ListNode curr3=headA;
        ListNode curr4=headB;
        if(count1>=count2)
        {
            int diff1 = count1-count2;
            for(int i=0; i<diff1; i++)
            {
                curr3=curr3.next;
            }
            while(curr3!=null && curr4!=null)
            {
                if(curr3==curr4)
                {
                    return curr3;
                }
                curr3=curr3.next;
                curr4=curr4.next;
            }
        }
        else if(count1<count2)
        {
            int diff1 = count2-count1;
            for(int i=0; i<diff1; i++)
            {
                curr4=curr4.next;
            }
            while(curr3!=null && curr4!=null)
            {
                if(curr3==curr4)
                {
                    return curr3;
                }
                curr3=curr3.next;
                curr4=curr4.next;
            }
        }
        return null;
    }
}

//here a diff aaproach would be using hashset...where we can traverse 1st list and store the address of each node in hashset
// again we can traverse 2nd list and store each address of each node in hashset and as we encounter some address already there 
// it means that it is the intersection point as it must have been visited and added in hashset during 1st list traversal
// the second aaproach that i did in this code is that first i am checking the length of both the linked list
// and acc to which length is larger..calculating the diff and moving the starting point of larger list by that diff
// so that both list can start from the same position and by this way from there onwards moving starting nodes of both list one node at a time
// we can easily find the intersection point by checking the next of the nodes if they equal that means that is the intersection point