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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)return null;
        
        
        ListNode node1 = head;
        int size=0;
        while(node1!=null){
            ++size;
            node1=node1.next;
        }
        
        
        int position=size-n;
        
        ListNode node2=head;
        int i=1;
        
        while(node2!=null){
            if(position==0){
                head=head.next;
                break;
            }
            if(position==i){
                node2.next=node2.next.next;
            }
            node2=node2.next;
            i++;
        }
        return head;
    }
}