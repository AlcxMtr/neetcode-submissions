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
    int mcounter = 0;
    public void reorderList(ListNode head) {
        int counter = 0;
        ListNode p = head;
        while (p != null) {
            counter += 1;
            p = p.next;
        }

        if (counter == 0 || counter == 1) return;
        
        int second_half = (counter+1)/2;

        ListNode middle = head;
        for (int i = 0; i < second_half-1; i++) {
            middle = middle.next;
        }

        ListNode middle_temp = middle.next;
        middle.next = null;
        middle = middle_temp;
        
        reorderHelper(head, middle);
    }

    public ListNode reorderHelper(ListNode head, ListNode middle) {
        if (middle.next != null) {
            head = reorderHelper(head, middle.next);
            middle.next = null;
        }
        if (head.next != null) {
            middle.next = head.next;
        }
        head.next = middle;
        return head.next.next;
    }
}
