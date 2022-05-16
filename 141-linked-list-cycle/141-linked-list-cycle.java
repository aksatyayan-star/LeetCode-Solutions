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
    public boolean hasCycle(ListNode head) {
        
        /*ListNode temp = new ListNode();
        ListNode curr = head;
        while(curr!=null)
        {
            if(curr.next==null)
            {
                return false;
            }
            if(curr.next == temp)
            {
                return true;
            }
            ListNode curr_next = curr.next;
            curr.next=temp;
            curr = curr_next;
        }
        return false;
        */
        HashSet<ListNode> s = new HashSet<ListNode>();
        for(ListNode curr=head; curr!=null; curr=curr.next)
        {
            if(s.contains(curr))
            {
                return true;
            }
            s.add(curr);
        }
        return false;
        
        // here the hashset approcah is like traverse the elements of linked list using curr in for loop and curr.next as increament in for loop
        // store it in hashset...and if already present in hashset return true 
        // as then it must have already been visited and we are encountering it again that means there is a cycle
    }
}
// modify linked list references approach here whole linked list will be destroyed
// the first commented approach is like we create a temp node and as we traverse throught the linked list
// we store curr's next to curr_next var...and make curr.next = temp...i.e when traversing lets say we on some node
// so for that node we isolate it by first storing its next elemnts in curr_next and making its next(i.e curr.next) to temp
// we break its link with other nodes and connect it to temp node(using curr.next = temp)
// the same way we do with every node as long as during traversing we are encountering nodes
// now we also check if curr.next == null then return false as we reached the last node and no loop was detected 
// if loop then curr.next never be equal to false
// if loop then in that condition curr.next must be equal to temp...we can understand it by the fact that
// as we are traversing through the list and encountering each node and making its next as temp
// so if during traversing we encountered some node whose next is temp then it means we must have alredy visited that node
// then only we would have made that connection to temp...so it means there is a node whose next is pointing us to some node we already visited
// and hence we are getting that visited node's next already as temp without even making that connection now 
// beacuse we must have already made that connection when we visited it for the first time...so that means there is a cycle as we visiting that node again