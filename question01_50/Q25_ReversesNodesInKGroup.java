package question01_50;

class Q25_ReversesNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 边界问题
        if(k == 0)  return head;

        // 如果子序列中节点个数小于 k，则无需倒序

        ListNode curr = head;
        int count = 0;

        // 找到最后一个节点
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        // 如果子序列中节点个数等于 k，则做倒序
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
