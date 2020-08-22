package question01_50;

/**
 * 24. Swap Nodes in Pairs
 * 节点俩俩对换
 *
 */

public class Q24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        // 情况有 1：节点总数为单数 2：节点总数为双数
        while(head != null){
            if(head.next == null){
                node.next = new ListNode(head.val);
                node = node.next;
            }else{
                node.next = new ListNode(head.next.val);
                node = node.next;
                node.next = new ListNode(head.val);
                node = node.next;
                head = head.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
