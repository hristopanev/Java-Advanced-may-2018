package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;


public class DatabaseTest {

    private static final Integer[] INITIAL_ELEMENTS = new Integer[]{1, 2, 3};

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThanOneElement() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Database database = new Database(new Integer[17]);
    }

    @Test
    public void constructingDatabaseShouldIncreaseElementsCount() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database database = new Database(DatabaseTest.INITIAL_ELEMENTS);

        Field field = Database.class.getDeclaredField("elementsCount");
        field.setAccessible(true);
        int fieldCurrentValues = field.getInt(database);

        Assert.assertEquals(DatabaseTest.INITIAL_ELEMENTS.length, fieldCurrentValues);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(DatabaseTest.INITIAL_ELEMENTS);

        db.add(null);
    }

    @Test
    public void addElementShouldIncreaseElementCount() throws OperationNotSupportedException {
        Database db = new Database(DatabaseTest.INITIAL_ELEMENTS);

        for (int i = 0; i < 3; i++) {
            db.add(i);
        }

        Assert.assertEquals(db.getElements().length,DatabaseTest.INITIAL_ELEMENTS.length + 3);
    }

    @Test
    public void removeShouldRemoveOnlyLastElement() throws OperationNotSupportedException {
        Database db = new Database(DatabaseTest.INITIAL_ELEMENTS);

        db.remove();
        int length = db.getElements().length;
        Assert.assertEquals(length, DatabaseTest.INITIAL_ELEMENTS.length - 1);
    }
}