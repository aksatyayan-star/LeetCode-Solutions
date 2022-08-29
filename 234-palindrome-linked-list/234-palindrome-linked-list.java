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
        for(int j=0; j<count/2; j++)
        {
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