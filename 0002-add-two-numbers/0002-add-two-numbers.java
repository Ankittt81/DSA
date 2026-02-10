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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        int q=0;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val+q;
            int rem=sum%10;
            q=sum/10;
            ListNode nn=new ListNode(rem);
            temp.next=nn;
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+q;
            int rem=sum%10;
            q=sum/10;
            ListNode nn=new ListNode(rem);
            temp.next=nn;
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val+q;
            int rem=sum%10;
            q=sum/10;
            ListNode nn=new ListNode(rem);
            temp.next=nn;
            temp=temp.next;
            l2=l2.next;
        }
        if(q>0){
            ListNode nn=new ListNode(q);
            temp.next=nn;
            temp=temp.next;
        }
        return dummy.next;
    }
}