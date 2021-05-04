package cn.wzz.test;


class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(7);
        ListNode node2 = new ListNode(6);
        node2.next = new ListNode(3);
        ListNode listNode = addInList(node1, node2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        ListNode l1 = reverse(head1);
        ListNode l2 = reverse(head2);
        ListNode result = new ListNode(0);
        // 升位
        int c = 0;
        while(l1 != null || l2 != null || c!=0) {
            int v1 = l1!=null?l1.val:0;
            int v2 = l2!=null?l2.val:0;
            int val = v1 + v2 + c;
            c = val/10;
            ListNode cur = new ListNode(val%10);
            cur.next = result.next;
            result.next = cur;
            if(l1 != null) {
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return result.next;
    }

    public static ListNode reverse(ListNode node) {
        if(node==null){
            return node;
        }
        ListNode pre = null;
        ListNode next = null;
        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}