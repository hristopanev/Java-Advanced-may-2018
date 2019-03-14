package stackOfString;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(0, element);
    }

    public String pop() {
        this.ensureSize();

        return this.data.remove(0);
    }

    public String peek() {
        this.ensureSize();

        return this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    private void ensureSize() {
        if (this.data.isEmpty()) {
            throw new InvalidDnDOperationException();
        }
    }
}
