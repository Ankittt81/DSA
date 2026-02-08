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
    ListNode slow=null;
    ListNode fast=null;
    public ListNode detectCycle(ListNode head) {
        if(!hasCycle(head)) return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
        
    }

    boolean hasCycle(ListNode head){
        if(head==null) return false;
        slow=head;
        fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) return true;
        }
        return false;
    }
}