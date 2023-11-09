/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(ListNode node:lists)
        {
            while(node!=null)
            {
                p.add(node.val);
                node=node.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(!p.isEmpty())
        {
            ListNode temp=new ListNode(p.poll());
            tail.next=temp;
            tail=tail.next;
        }
        return dummy.next;
    }
}