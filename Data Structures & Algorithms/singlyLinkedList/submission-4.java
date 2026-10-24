class LinkedList {

    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    int size;
    Node head;
    Node tail;

    public LinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        return t.value;
    }

    public void insertHead(int val) {
        head = new Node(val, head);
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    public void insertTail(int val) {
        Node new_tail = new Node(val, null);
        if (tail != null) {
            tail.next = new_tail;
        }
        tail = new_tail;
        size++;
        if (head == null) {
            head = new_tail;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;  // If the list is now empty, update tail to null
            }
            return true;
        }

        Node t = head;
        for (int i = 0; i < index-1; i++) {
            t = t.next;
        }
        t.next = t.next.next;
        size--;

        if (t.next == null) {
            tail = t;
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> array = new ArrayList<>(size);
        Node t = head;
        while (t != null) {
            array.add(t.value);
            t = t.next;
        }
        return array;
    }
}
