/**
 * Implementation of a doubly circularly linked list.
 * The fact that the last node links to the first and visa versa makes certain
 * things simpler and other things more difficult.
 * @param <T> type of elements within the list
 */

public class DoublyCircularlyLinkedList<T> {
    private class Node {
        T value;
        Node prev, next;

        /**
         * Constructor taking only a value argument.  Circularly links to itself.
         */
        Node(T value) {
            this.value = value;
            next = this;
            prev = this;
        }

        Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head, tail;

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Node p = head;
        do {
            ++count;
            p = p.next;
        } while (p != head);

        return count;
    }

    /**
     * adds the given item at the end of the list
     * @param value value of element
     */
    public void add(T value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value, head, tail);
            tail = tail.next;
            head.prev = tail;
        }
    }

    /**
     * Inserts an element at the given position
     * If the index is larger than the size of the list or smaller than 0,
     * then returns false
     * @param value value of element
     * @param index location to insert it (must be 0 <= index <= size())
     * @return whether the addition was successful
     */
    public boolean add(T value, int index) {
        if (index < 0) {
            return false;
        }

        if (index == 0) {
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                head = new Node(value, head, tail);
                head.next.prev = head;
                head.prev = tail;
                tail.next = head;
            }
            return true;
        } else {
            Node p = head;
            int i = 0;

            while (true) {
                //reached end of list
                if (p == head && i != 0) {
                    if (i == index) {
                        //treat as appending
                        tail = new Node(value, head, tail);
                        tail.prev.next = tail;
                        head.prev = tail;
                        return true;
                    } else {
                        //index is beyond the size of the list
                        return false;
                    }
                }

                //reached desired index
                if (i == index) {
                    Node newNode = new Node(value, p, p.prev);
                    p.prev.next = newNode;
                    p.prev = newNode;
                    return true;
                }

                p = p.next;
                ++i;
            }
        }
    }

    /**
     * removes the element at the given position
     * @param index position of element to remove
     * @return whether the removal is successful
     */
    public boolean remove(int index) {
        if (isEmpty()) {
            return false;
        }

        int i = 0;
        Node p = head;
        do {
            if (i == index) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                return true;
            }

            ++i;
            p = p.next;
        } while (p != head);

        return false;
    }

    /**
     * removes the first element with the given value
     * @param value value of element to remove
     * @return whether the removal is successful
     */
    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }

        Node p = head;
        do {
            if (p.value.equals(value)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                return true;
            }

            p = p.next;
        } while (p != head);

        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder(head.value.toString());
        Node p = head.next;

        while (p != head) {
            sb.append(", ");
            sb.append(p.value);

            p = p.next;
        }

        return sb.toString();
    }
}
