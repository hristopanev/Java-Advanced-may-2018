package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static final String[] INITIAL_DATA = new String[]{"One", "Two", "Three"};

    private ListIterator listIterator;

    @Before
    public void each() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ListIteratorTest.INITIAL_DATA);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void moveShouldMoveCorrectlyToTheNextElement() {
        assertTrue(this.listIterator.move());
    }

    @Test
    public void moveShouldFalseWhenAtTheLastElement(){
        for (int i = 0; i < 2; i++) {
            this.listIterator.move();
        }

        assertFalse(this.listIterator.move());
    }


    @Test
    public void hasNextShouldReturnFalseOnEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnTrueIfThereAreNextElements() {
        assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void printShouldReturnCorrectElement() {
        assertEquals(ListIteratorTest.INITIAL_DATA[0], this.listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void printOnEmptyListShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }


}