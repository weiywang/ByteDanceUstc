package LinkListAndTree;

public class ReverseList {
    public static ListNode reverseList(ListNode head){
        ListNode reverseHeadNode = null;
        ListNode nowNode = head;
        ListNode prevNode = null;
        while(nowNode != null){
            ListNode nextNode = nowNode.next;
            if(nextNode == null){
                reverseHeadNode = nowNode;
            }
            nowNode.next = prevNode;
            prevNode = nowNode;
            nowNode = nextNode;
        }
        return reverseHeadNode;
    }

    public static void main(String[] Args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode reverseHead = reverseList(head);
        while(reverseHead != null){
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }
}
