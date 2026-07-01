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
    public ListNode reverse(ListNode start,ListNode end){
        ListNode prev=null;
        while(start!=end){
            ListNode frowd=start.next;
            start.next=prev;
            prev=start;
            start=frowd;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null) return head;
            temp=temp.next;
        }
        ListNode newnode=reverse(head,temp);
        head.next=reverseKGroup(temp,k);
        return newnode;
    }
}