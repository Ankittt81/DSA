/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=getsize(headA);
        int sizeB=getsize(headB);
        if(sizeA==0 || sizeB==0) return null;
        if(sizeB>sizeA) return getIntersectionNode(headB,headA);
        int diff=sizeA-sizeB;
        ListNode temp=headA;
        while(diff!=0){
            diff--;
            temp=temp.next;
        }
        ListNode moveB=headB;
        while(temp!=null && moveB!=null){
            if(temp==moveB) return temp;
            temp=temp.next;
            moveB=moveB.next;
        }
        return null;
    }
    int getsize(ListNode headA){
        if(headA==null) return 0;
        int count=1;
        ListNode temp=headA;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
}