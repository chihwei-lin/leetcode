package question01_50;

/**
 * 19. Remove Nth Node From End of List
 *
 * 1. initialize two pointers as 0 (slow, fast)
 * 2. move fast pointer n times ahead slow (gap == n)
 * 3. when fast pointer reaches the end of the list, the element pointed by slow pointer can be deleted
 */

public class RemoveNthNodeFromEndofList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        };

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode n1 = dummy, n2 = dummy;

        for (int i = 0; i <= n; i++) {      // move n2 to index n
            n2 = n2.next;
        }

        while(n2 != null){
            n1 = n1.next;
            n2 = n2.next;
        }

        n1.next = n1.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        for (int i = 0; i < 10; i++) {
            node.next = new ListNode(i+1);
            node = node.next;
        }
    }
}
