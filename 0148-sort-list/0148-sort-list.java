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
    public ListNode sortList(ListNode head) {
        return mergesort(head);

    }
    ListNode mergesort(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode mid=middle(head);
        ListNode l2=mid.next;
        mid.next=null;
        ListNode t1= mergesort(head);
        ListNode t2= mergesort(l2);

        return merge(t1,t2);
    }
    ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=null;
        if(l1.val<=l2.val){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        ListNode temp=head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }

        if(l1==null) temp.next=l2;
        else if(l2==null) temp.next=l1;
        return head;
    }

    ListNode middle(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}