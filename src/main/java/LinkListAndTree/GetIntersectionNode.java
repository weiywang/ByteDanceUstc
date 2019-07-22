package main.java.LinkListAndTree;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode p = headA;
        while(p.next != null){
            p = p.next;
        }
        p.next = headA;

        ListNode joinPoint = detectCycle(headB);

        p.next = null;

        return joinPoint;
    }

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
