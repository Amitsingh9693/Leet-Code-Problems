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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;

        ListNode temp=head;
        int len=0;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }

        k=k%(len+1);
        int n=len-k+1;

        if(n==0) return head;
        temp.next=head;
        temp=head;
        int i=0;
        while(i<n-1){
            temp=temp.next;
            i++;
        }

        ListNode s=temp.next;
        temp.next=null;
        return s;
    }
}