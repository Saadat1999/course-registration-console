package list;

public class Node {

    Node prev;
    Node next;
    Object value;

    public Node(Node node, Object value) {
        this.value = value;
        if(node!=null) {
            prev = node;
            prev.next=this;
        }
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
