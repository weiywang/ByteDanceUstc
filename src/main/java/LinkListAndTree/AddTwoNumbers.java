package LinkListAndTree;

public class AddTwoNumbers {
    //两个链不是等长的，但没有太大的影响
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            l1 = new ListNode(0);
        }

        if(l2 == null){
            l2 = new ListNode(0);
        }

        if(l1.next == null && l2.next == null){
            int val = l1.val + l2.val;
            if(val > 9){
                ListNode node = new ListNode(val % 10);
                node.next = new ListNode(val / 10);
                return node;
            }else {
                ListNode node = new ListNode(val);
                return node;
            }
        }else{
            int val = l1.val + l2.val;
            if(val > 9){
                val = val - 10;
                if(l1.next != null) l1.next.val++;
                else l2.next.val++;
            }
            ListNode node = new ListNode(val);
            node.next = addTwoNumbers(l1.next, l2.next);
            return node;
        }

    }

}
