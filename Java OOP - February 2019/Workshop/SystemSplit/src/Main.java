import core.Engine;
import core.SystemSplit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SystemSplit systemSplit = new SystemSplit();
        Engine engine = new Engine(systemSplit);

        engine.run();

        System.out.println(systemSplit.toString());

    }
}
