package question01_50;

/**
 * 19. Remove Nth Node From End of List
 * 移除倒数第 n 个节点
 *
 * 双指针问题
 * 1：利用第二指针移动到与第一指针差距为 n
 * 2：当第二指针移动到尾端，则第一指针指向的元素就是要被删除的元素
 */

public class Q19_RemoveNthNodeFromEndofList {
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

        ListNode pointerA = dummy;
        ListNode pointerB = dummy;

        // 边界问题
        if(head == null || n < 0)    return null;

        // 移动第二指针，让第一与第二指针的差距为 n
        for(int i=0;i<n;i++){
            pointerB = pointerB.next;
        }

        while(pointerB.next != null){
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }

        pointerA.next = pointerA.next.next;

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
