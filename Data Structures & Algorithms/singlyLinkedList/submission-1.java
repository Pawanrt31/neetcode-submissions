class LinkedList {

    private Node head, tail;
    private int size;

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
        this.size = 0;
    }

    public int get(int index) {
        if(isEmpty() || !isElementIndex(index)) {
            return -1;
        } 
        Node node = getNode(index);
        return node.val;
    }

    private Node getNode(int index) {
        Node cur = head.next;
        for(int i=0;i<index;i++) {
            cur = cur.next;
        } 
        return cur;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if(this.size == 0) {
            tail = newNode;
        }
        this.size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        this.size++;
    }

    public boolean remove(int index) {
        if(isEmpty()) {
            return false;
        }
        if(!isElementIndex(index)) {
            return false;
        }
        Node prev = head;
        for(int i=0;i<index;i++) {
            prev = prev.next;
        }
        Node nodeToBeDeleted = prev.next;
        prev.next = nodeToBeDeleted.next;
        if(index == size - 1) {
            tail = prev;
        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node cur = head.next;
        while(cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }
        return values;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}