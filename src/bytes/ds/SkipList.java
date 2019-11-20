package bytes.ds;

public class SkipList {




}


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    void setNext(Node next) {
        this.next = next;
    }

}