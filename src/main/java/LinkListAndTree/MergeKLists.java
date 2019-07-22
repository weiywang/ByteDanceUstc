package main.java.LinkListAndTree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(o->o.val));

        for(ListNode node: lists){
            while(node != null){
                queue.add(node);
                node = node.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode res = head;
        ListNode cur;

        while((cur = queue.poll()) != null){
            head.next = cur;
            head = head.next;
        }

        head.next = null;
        return res.next;
    }
}
