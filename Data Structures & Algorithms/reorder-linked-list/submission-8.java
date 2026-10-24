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
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode p = head;
        ArrayList<ListNode> arr = new ArrayList<>();
        while (p != null) {
            arr.add(p);
            p = p.next;
        }
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            int j = i/2;
            if (i%2 == 0) {
                arr.get(j).next = arr.get(size-1-j);
            } else {
                arr.get(size-1-j).next = arr.get(j+1);
            }
        }
        arr.get((size/2)).next = null;
    }
}
