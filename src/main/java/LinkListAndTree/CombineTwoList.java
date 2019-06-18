package LinkListAndTree;

public class CombineTwoList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode result = l;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    l.next = new ListNode(l1.val);
                    l = l.next;
                    l1 = l1.next;
                }
                else{
                    l.next = new ListNode(l2.val);
                    l = l.next;
                    l2 = l2.next;
                }
            }
            else{
                if(l1 != null){
                    l.next = new ListNode(l1.val);
                    l = l.next;
                    l1 = l1.next;
                }
                else{
                    l.next = new ListNode(l2.val);
                    l = l.next;
                    l2 = l2.next;
                }
            }
        }
        return result.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l = mergeTwoLists(l1, l2);
        System.out.println(l.val);
        System.out.println(l.next.val);
    }
}
