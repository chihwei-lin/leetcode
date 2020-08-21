package question01_50;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * 结合 k 个已排序的序列
 *
 * 解法：用 min heap 处理
 */

public class Q23_MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        // 边界问题
        if(lists.length == 0)   return null;
        if(lists.length == 1)   return lists[0];

        // 构造一个最小堆 min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode head : lists){
            while(head != null){
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode node = dummy;
        // 将 minHeap 转换成 LinkedList
        while(!minHeap.isEmpty()){
            node.next = new ListNode(minHeap.remove());
            node = node.next;
        }

        return dummy.next;
    }
}
