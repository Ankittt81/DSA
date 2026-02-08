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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(-1);
        ListNode oddTemp=odd;
        ListNode even=new ListNode(-1);
        ListNode evenTemp=even;

        ListNode temp=head;
        int size=1;
        while(temp!=null){
            if(size%2==0){
                evenTemp.next=temp;
                evenTemp=evenTemp.next;
            }else{
                oddTemp.next=temp;
                oddTemp=oddTemp.next;
            }
            temp=temp.next;
            size++;
        }
        evenTemp.next=null;
        oddTemp.next=even.next;
        return odd.next;
    }
}