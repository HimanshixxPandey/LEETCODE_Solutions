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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode dummy=new ListNode(0);
        ListNode first=head;
        ListNode prev=dummy;
        prev.next=head;
        while(first !=null && first.next!=null)
        {
            ListNode second=first.next;
            ListNode future=first.next.next;
            second.next=first;
            prev.next=second;
            first.next=future;
            prev=first;
            first=future;
        }
        return dummy.next;
        
    }
}