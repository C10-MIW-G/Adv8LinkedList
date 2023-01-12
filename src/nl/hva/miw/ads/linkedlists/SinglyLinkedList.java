package nl.hva.miw.ads.linkedlists;

import java.util.List;

/**
 * Singly linked list.
 *
 * @author michel
 */
public class SinglyLinkedList<E> implements List<E> {

    private class Node<E> {
        E value;

        Node<E> next = null;      // Link to next node

        public Node(E value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node<E> head = null;      // Link to first node

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    /**
     * Return the value in the list at position index.
     *
     * @param index
     * @return
     */
    public E get( int index ) {
        return findNodeAtIndex(index).value;
    }

    /**
     * Add an element to the list at position index.
     *
     * @param index
     * @param value
     */
    public void add( int index, E value ) {
        // Implement, create a new Node for this entry.

        Node<E> newNode = new Node<>( value );

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> previousNode = findNodeAtIndex(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }

        size++;
    }

    private Node<E> findNodeAtIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * Remove an element from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            head = head.next;
        } else {
            Node<E> previousNode = findNodeAtIndex(index - 1);
            previousNode.next = previousNode.next.next;
        }

        size--;
        // Implement, remove the corresponding node from the linked list.
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("SinglyLinkedList{size=").append(size).append("}");

        Node<E> current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }



}
