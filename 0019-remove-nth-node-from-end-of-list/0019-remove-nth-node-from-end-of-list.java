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
        ListNode fast=head;
        ListNode slow=head;
        if(head==null)
            return null;
        if(head.next==null)
        {
            return null;
        }
        while(n!=0)
        {
            fast=fast.next;
            n--;
        }
        if(fast==null)
        {
            ListNode temp=head;
            head=head.next;
            temp.next=null;
            return head;
        }
        while(fast.next!=null)
        
        {
            fast=fast.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        slow.next=slow.next.next;
        temp.next=null;
        return head;
        
       
//         ListNode slow=head;
//         ListNode prev=head;
//         slow=slow.next;
//         while(fast.next!=null)
//         {
//             prev=slow;
//             fast=fast.next;
//             slow=slow.next;
//         }
//         prev.next=slow.next;
//         slow.next=null;
//         return head;
        
    }
}