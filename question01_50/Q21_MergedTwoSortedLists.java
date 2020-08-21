package question01_50;

import java.util.List;

public class Q21_MergedTwoSortedLists {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;

        // l1，l2 都不为空
        ListNode result = new ListNode();
        ListNode dummy = result;

        // 遍历 l1 与 l2
        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l1 != null && l2 == null){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{      // l1 != null && l2 != null
                if(l1.val < l2.val){
                    result.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    result.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            result = result.next;
        }

        return dummy.next;
    }
}
