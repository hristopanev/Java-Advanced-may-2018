import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class p04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String validNameElement = "[A-Z][A-Za-z0-9]+";
        String validDelimiter = "\\s\\|\\s";

        Map<String, Map<String, Set<String>>> classes = new LinkedHashMap<>();
        String validLine = String.format("%1$%s%2$%s%1$%s%2$%s%1$%s", validNameElement, validDelimiter);

        String line;
        while (true) {
            if ("It's testing time!".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            if (!line.matches(validLine)) {
                continue;
            }

            String[] tokens = line.split("\\s+");

            String clazz = tokens[0];
            String method = tokens[1];
            String unitTest = tokens[2];

            Set<String> unitTests = new LinkedHashSet<>();
            Map<String, Set<String>> methods = new LinkedHashMap<>();

            if (classes.containsKey(clazz)) {
                methods = classes.get(clazz);
            }

            if (methods.containsKey(method)) {
                unitTests = methods.get(method);
            }

            unitTests.add(unitTest);
            methods.put(method, unitTests);
            classes.put(clazz, methods);
        }
        StringBuilder result = new StringBuilder();

        classes.entrySet().stream()
                .sorted((c1, c2) -> {
                    int amountUnitTestClazz1 = c1.getValue().values().stream()
                            .mapToInt(m -> m.size()).sum();
                    int amountUnitTestClazz2 = c2.getValue().values().stream()
                            .mapToInt(m -> m.size()).sum();

                    int comparatorByAmountOfUnitTest = amountUnitTestClazz2 - amountUnitTestClazz1;
                    if (comparatorByAmountOfUnitTest != 0) {
                        return comparatorByAmountOfUnitTest;
                    }

                    int amountMethodsclazz1 = c1.getValue().values().size();
                    int amountMethodsclazz2 = c2.getValue().values().size();

                    int comparatorByAmountOfMethods = amountMethodsclazz1 - amountMethodsclazz2;
                    if (comparatorByAmountOfMethods != 0) {
                        return comparatorByAmountOfMethods;
                    }

                    int comparatorByNames = c1.getKey().compareTo(c2.getKey());
                    return comparatorByNames;


                })
                .forEach(c -> {
                    result.append(String.format("%s:", c.getKey())).append(System.lineSeparator());
                    c.getValue().entrySet().stream()
                            .sorted((m1, m2) -> {
                                int amountOfUnitTestsMethod1 = m1.getValue().size();
                                int amountOfUnitTestsMethod2 = m2.getValue().size();

                                int comparatorByAmountTests = amountOfUnitTestsMethod2 - amountOfUnitTestsMethod1;

                                if (comparatorByAmountTests != 0) {
                                    return comparatorByAmountTests;
                                }

                                int comparatorByNames = m1.getKey().compareTo(m2.getKey());
                                return comparatorByNames;
                            })
                            .forEach(m -> {
                                result.append(String.format("##%s", m.getKey())).append(System.lineSeparator());

                                m.getValue().stream()
                                        .sorted((u1, u2) -> {
                                            int comparatorByNamesLength = u1.length() - u2.length();

                                            if (comparatorByNamesLength != 0) {
                                                return comparatorByNamesLength;
                                            }

                                            int comparatorByNames = u1.compareTo(u2);
                                            return comparatorByNames;
                                        })
                                        .forEach(uniTest -> {
                                            result.append(String.format("####%s", uniTest)).append(System.lineSeparator());
                                        });
                            });

                });
        System.out.println(result);
    }
}
