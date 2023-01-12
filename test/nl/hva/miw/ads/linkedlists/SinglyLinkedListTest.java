package nl.hva.miw.ads.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void add() {
        SinglyLinkedList l = new SinglyLinkedList();
        System.out.println(l);

        l.add(0, 400); // [400]
        l.add(0, 100); // [100, 400]
        l.add(1, 200); // [100, 200, 400]
        l.add(2, 300); // [100, 200, 300, 400]
        l.add(4, 500); // [100, 200, 300, 400, 500]

        String expected = "SinglyLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        SinglyLinkedList l = new SinglyLinkedList();
        System.out.println(l);

        l.add(0, 400); // [400]
        l.add(0, 100); // [100, 400]
        l.add(1, 200); // [100, 200, 400]
        l.add(2, 300); // [100, 200, 300, 400]
        l.add(4, 500); // [100, 200, 300, 400, 500]

        l.remove(2);

        String expected = "SinglyLinkedList{size=4} 100 200 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }
}