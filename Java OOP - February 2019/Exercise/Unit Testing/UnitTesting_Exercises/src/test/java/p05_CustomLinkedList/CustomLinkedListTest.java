package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> linkedList;

    @Before
    public void createLinkList() throws Exception {
        this.linkedList = new CustomLinkedList<>();
    }

    @Test
    public void containsReturnTruIfElementIsPresentInsideLinkedList(){
        this.linkedList.add(12);
        this.linkedList.add(22);
        this.linkedList.add(32);

        assertTrue(this.linkedList.contains(22));
    }

    @Test
    public void containsReturnFalseOnEmptyLinkList(){
        assertFalse(this.linkedList.contains(1));
    }

    @Test
    public void containsReturnFalseIfElementIsNotPresent(){

        for (int i = -9; i < 200; i++) {
            this.linkedList.add(i);
        }
        assertFalse(this.linkedList.contains(-10));
    }

    @Test
    public void indexOfShouldReturnCorrectValue(){
        for (int i = 0; i < 100; i++) {
            this.linkedList.add(i);
        }
        assertEquals(99, this.linkedList.indexOf(99));
    }

    @Test
    public void indexOfShouldReturnMinusOneIfElementIsNotPresentInLinkedList(){
        assertEquals(-1, this.linkedList.indexOf(12));
    }
}