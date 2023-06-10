public class ll {
    Node head;
    private int size;

    ll(){
        size=0;
    }

    class Node{
        
        int data;
        Node next;

         Node(int data){
            this.data = data;
            this.next=null;
            size++;
         }
    }
    //addfirst
    public void addFirst(int data){
        Node newnode = new Node(data);
        newnode.next= head;
        head= newnode;
    }
    //addlast
    public void addLast(int data){
        Node newnode = new Node(data);
        if(head==null){
            newnode.next=head;
            head=newnode;
        }

        Node lastnode=head;
        while(lastnode.next!=null){
            lastnode=lastnode.next;
        }
        lastnode.next=newnode;
    }
    //deletefirst
    public void deleteFirst(){
        if(head.next==null){
            return;
        }
        head=head.next;
        size--;
    }
    //deletelast

    public void deleteLast(){
        if(head==null)return;

        size--;

        if(head.next==null){
            head=null;
            return;
        }

        Node secondlast = head;
        Node last = head.next;

        while(last.next!=null){
            secondlast= secondlast.next;
            last = last.next;
        }
        secondlast.next=null;
    }
    //size
    
    public int getSize(){
        return size;
    }

    public void printNode(){
        Node currNode=head;
        
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }

        
            System.out.print("NULL");
        
    }

    public static void main(String args[]){
        ll list = new ll();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addLast(5);
        list.addLast(4);

        // list.deleteFirst();
        list.deleteLast();

        list.printNode();
        System.out.println("\n"+list.getSize());
    }
}
