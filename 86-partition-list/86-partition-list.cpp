/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* part1=new ListNode(0);
        ListNode* ans=part1;
        ListNode* part2=new ListNode(0);
        ListNode* tt=part2;
        while(head){
            if(head->val<x){
                part1->next=new ListNode(head->val);
                part1=part1->next;
            }
            if(head->val>=x){
                part2->next=new ListNode(head->val);
                part2=part2->next;
            }
            head=head->next;
        }
        part1->next=tt->next;
        return ans->next;
        
        
    }
};