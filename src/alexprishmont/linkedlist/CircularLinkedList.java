/**
 * Created by Aleksandr Prišmont
 * 2019
 */

package alexprishmont.linkedlist;

class CircularLinkedList {
    Node head = null;
    Node tail = null;
    private int size = 0;

    /**
     * Insert element at the beginning
     * @param data
     */
    void insert(int data) {
        Node newNode = new Node(data);
        if (isListEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size ++;
    }

    /**
     * Push element to the end
     * @param data
     */
    void push(int data) {
        if (isListEmpty()) {
            insert(data);
            return;
        }

        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
        size ++;
    }

    /**
     * Delete last element of the list
     */
    void pop() {
        if (isListEmpty()) {
            return;
        }
        tail = getBeforeLast();
        tail.next = head;
        size --;
    }

    /**
     * Delete first element of the list
     */
    void shift() {
        if (isListEmpty()) {
            return;
        }
        head = head.next;
        tail.next = head;
        size --;
    }

    /**
     * Delete concrete element from the list
     * @param element
     */
    void unset(int element) {
        if (isListEmpty()) {
            return;
        }
        Node elementNode = getNode(element);
        if (elementNode == null) {
            return;
        }

        if (elementNode == head) {
            if (getSize() == 1) {
                head = null;
                tail = null;
                size --;
                return;
            }

            Node ptr = head;
            while (ptr.next != head) {
                ptr = ptr.next;
            }
            ptr.next = head.next;
            head = head.next;
            return;
        }

        Node temp = null;
        Node prevnode = head;
        Node current = head.next;

        while (current != null) {
            if (current.data == element) {
                temp = current;
                current = null;
                continue;
            }
            prevnode = prevnode.next;
            current = current.next;
        }

        prevnode.next = temp.next;
        size --;
    }

    /**
     * Add element after concrete index to the list
     * @param afterIndex
     * @param data
     */
    void add(int afterIndex, int data) {
        if (isListEmpty()) {
            insert(data);
            return;
        }

        if (afterIndex >= size) {
            push(data);
            return;
        }

        Node n = getNodeAtIndex(afterIndex);
        Node newnode = new Node(data);

        newnode.next = n.next;
        n.next = newnode;
    }

    /**
     * Display list
     */
    void display() {
        System.out.println("Circular linked list: ");
        if (isListEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(" " + temp.data);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    /**
     * Get element at the concrete index
     * @param index
     * @return
     */
    int elementAt(int index) {
        if (index > size || index < 0) {
            return -1;
        }
        Node n = head;
        while (index != 0) {
            n = n.next;
            index --;
        }
        return n.data;
    }

    /**
     * Find element's position in the list
     * @param element
     * @return
     */
    int findElement(int element) {
        Node temp = head;
        int position = 0;

        do {
            if (temp.data == element) {
                break;
            }
            temp = temp.next;
            position ++;
        } while (temp != head);
        return position;
    }

    /**
     * Get list's size
     * @return
     */
    int getSize() {
        return size;
    }

    private boolean isListEmpty() {
        return size <= 0;
    }

    private Node getBeforeLast() {
        Node n = head;
        int position = 0;
        do {
            if (position == size - 2) {
                break;
            }
            n = n.next;
            position ++;
        } while(n != head);
        return n;
    }

    private Node getNodeAtIndex(int index) {
        Node n = head;
        int position = 0;
        do {
            if (position == index) {
                break;
            }
            n = n.next;
            position ++;
        } while(n != head);
        return n;
    }

    private Node getNode(int element) {
        Node n = head;
        do {
            if (n.data == element) {
                break;
            }
            n = n.next;
        } while (n != head);
        return n;
    }
}
