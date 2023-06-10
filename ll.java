public class ll {
    Node head;
    class Node{
        
        int data;
        Node next;

         Node(int data){
            this.data = data;
            this.next=null;

         }
    }
    
    public void addFirst(int data){
        Node newnode = new Node(data);
        newnode.next= head;
        head= newnode;
    }

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

    public void printNode(){
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
    }

    public static void main(String args[]){
        ll list = new ll();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addLast(5);
        list.addLast(4);

        list.printNode();
    }
}
