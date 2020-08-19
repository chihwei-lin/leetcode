package question01_50;

public class Q02_AddTwoNumbers {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;

            carry = sum / 10;
        }

        if(carry > 0)
            node.next = new ListNode(carry);

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
