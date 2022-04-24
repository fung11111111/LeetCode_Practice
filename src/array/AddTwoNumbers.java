package array;


public class AddTwoNumbers {
    public array.ListNode addTwoNumbers(array.ListNode l1, array.ListNode l2) {
        array.ListNode header = null;
        array.ListNode pre = null;

        int tmp = 0;
        while (l1 != null || l2 != null || tmp >= 1) {
            int currentVal = 0;
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }

            if (tmp >= 10) {
                currentVal = tmp % 10;
                tmp = tmp / 10;
            } else {
                currentVal = tmp;
                tmp = 0;
            }

            array.ListNode currentNode = new array.ListNode(currentVal);
            currentNode.next = null;
            if (header == null) {
                header = currentNode;
            }
            if (pre != null) {
                pre.next = currentNode;
            }
            pre = currentNode;
        }


        return header;
    }
}
