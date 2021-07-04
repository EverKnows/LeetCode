/**
 * @author jianmiao.xu
 * @date 2021/6/4
 */
public class s160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {

    }
}