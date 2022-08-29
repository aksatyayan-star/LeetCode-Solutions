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
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode curr1 = head;
        ListNode curr2 = head;
        int flag = 0;
        while(head!=null)
        {
            count++;
            head = head.next;
        }
        if(count==1)
        {
            flag = 1;
        }
        //System.out.println(count);
        ListNode prev = null;
        ListNode next = null;
        for(int i=0; i<count/2; i++)
        {
            next = curr1.next;
            curr1.next = prev;
            prev = curr1;
            curr1 = next;
            //System.out.println(prev.val);
        }
        curr2 = curr1.next;
        if(count%2==0){
            while(prev!=null && curr1!=null)
            {
                if(prev.val==curr1.val){
                    prev = prev.next;
                    curr1 = curr1.next;
                    flag = 1;
                }
                else{
                    flag = 0;
                    break;
                }
            }
        }
        if(count%2!=0)
        {
            while(prev!=null && curr2!=null)
            {
                if(prev.val==curr2.val){
                    prev = prev.next;
                    curr2 = curr2.next;
                    flag = 1;
                }
                else{
                    flag = 0;
                    break;
                }
            }  
        }
        if(flag==1)
        {
            return true;
        }
        else{
            return false;
        }
    }
}

// the logic is as we dont have to use extra space and in O(n) time complexity ...so we will have to modify linked list only
// so what i did is first traverse and get the length of linked list in count..if count =1 i.e only head then its palindrome..so set flag to 1
// next reverse the links in the linked list...or in simple words reverse the linked list till middle element in one side
// leave the other side as it is...now we will have to check if count even or odd...if even then simply start traversing both the list from the middle in opposite direction
// as half of the list is reversed...and if val matches set flag to 1 else set flag to 0 and break
// same in case for odd length also but for odd first move curr2 a node ahead from curr1 as in odd we have to leave the middle node as it as and start comparison from next node to this node
// hence same here just compare prev.val with curr2.val if it keeps matching keep moving them using next and set flag to 1
// else set flag to 0 and break...at the end if flag = 0 then return false else flag = 1 return true