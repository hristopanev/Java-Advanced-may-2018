package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.db = new Database(new Person(1, "Name"));
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void getElements() {
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
        public void findByUsernameCantFindPersonWithGivenUsername() throws OperationNotSupportedException {
        this.db.findByUsername("");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameFindsMoreThanOneResult() throws OperationNotSupportedException {
        this.db.add(new Person(12, "Name"));
        this.db.findByUsername("Name");
    }

    @Test
    public void findByUsernameReturnsCorrectPersonObject() throws OperationNotSupportedException {
        Person p = this.db.findByUsername("Name");

        assertEquals(p.getUsername(), "Name");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findById() {
    }
}