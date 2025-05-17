package list;

public class LinkedListTest {

    Node head;
    Node tail;
    int size;

    public LinkedListTest() {
        this.head = null;
        this.tail = null;
        this.size =0;
    }

    public void add(Object value) {
        Node newNode = new Node(tail, value);
        if(head==null) {
            head = newNode;
        }
        tail = newNode;
        size++;
    }
    private void remove(Node node) {
        if(node.prev!=null) {
            node.prev.next=node.next;
        } else {
            head=node.next;
        }
        if(node.next!=null) {
            node.next.prev = node.prev;
        } else {
            tail=node.prev;
        }
    }

    public void remove(int index) {
        if(index<0 || index >=size) {
            throw new ArrayIndexOutOfBoundsException("Index out of boundary");
        }
        Node current=head;
        for(int i=0; i<index; i++) {
            current=current.next;
        }
        remove(current);
        size--;
    }

    public int size() {
        return size;
    }

}
