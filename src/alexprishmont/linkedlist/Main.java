/**
 * Created by Aleksandr Prišmont
 * 2019
 */

package alexprishmont.linkedlist;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(1);
        list.insert(2);
        list.display();
        list.push(5);
        list.display();
        list.shift();
        list.display();
    }
}
