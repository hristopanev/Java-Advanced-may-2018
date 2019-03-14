package arrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random;

    RandomArrayList() {
        super();
        this.random = new Random();
    }

    public T getRandomElement() {

        if (super.isEmpty()){
            throw new IllegalArgumentException("get on empty list");
        }
        int index = this.random.nextInt(super.size());

        T element = super.get(index);
        super.remove(element);

        return element;
    }
}
