package LinkListAndTree;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode meetNode = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                meetNode = fast;
                break;
            }
        }

        if(meetNode == null){
            return null;
        }

        while(head != meetNode){
            head = head.next;
            if(head == meetNode){
                break;
            }

            meetNode = meetNode.next;
        }

        return meetNode;
    }
}
