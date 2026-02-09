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
        if(head==null) return null;

       int size=0;
       ListNode temp=head;
       while(temp!=null){
        temp=temp.next;
        size++;
       }
       int rem=size-n;
       if(rem==0) return head.next;
       temp=head;
       for(int i=1;i<rem;i++){
        temp=temp.next;
       }
       
       if(temp.next.next!=null) temp.next=temp.next.next;
       else temp.next=null;
       return head; 
    }
}