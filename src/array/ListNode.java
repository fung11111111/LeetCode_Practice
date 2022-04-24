package array;

public class ListNode {
    int val;
    ListNode next;
    ListNode pre;


    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }

    public int getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }
}
