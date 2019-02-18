import java.util.*;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputId = scanner.nextLine().split("\\s+");
        String[] inputAgent = scanner.nextLine().split("\\s+");

        ArrayDeque<String> agents = new ArrayDeque<>();
        ArrayDeque<String> ides = new ArrayDeque<>();

        for (String s : inputId) {
            ides.push(s);
        }

        for (String s : inputAgent) {
            agents.offer(s);
        }

        String line;
        while (true) {
            if ("stop".equalsIgnoreCase(line = scanner.nextLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            if (command.equalsIgnoreCase("add-id")) {
                ides.push(tokens[1]);
            } else if (command.equalsIgnoreCase("add-agent")) {
                agents.addLast(tokens[1]);
            } else if (command.equalsIgnoreCase("remove-id")) {
                System.out.println(ides.pop() + " has been removed.");
            } else if (command.equalsIgnoreCase("remove-agent")) {
                System.out.println(agents.pollLast() + " has left the queue.");
            } else if (command.equalsIgnoreCase("sort-id")) {
                sortedId(ides);
            }
        }

        int index = agents.size();
        while (index-- > 0) {
            System.out.printf("%s takes ID number: %s%n", agents.pollFirst(), ides.pop());

            if (agents.isEmpty() && !ides.isEmpty()) {
                System.out.println("No more agents left.");
                if (!ides.isEmpty()) {
                    for (String id : ides) {
                        System.out.println("ID number: " + id);
                    }
                }
            } else if (ides.isEmpty()) {
                for (String agent : agents) {
                    System.out.println(agent + " does not have an ID.");
                }
                return;
            }
        }

    }

    private static void sortedId(ArrayDeque<String> id) {
        ArrayList<String> sortId = new ArrayList<>();
        for (String s : id) {
            sortId.add(s);
            id.pop();
        }
        Collections.sort(sortId);
        for (String s : sortId) {
            id.push(s);
        }
    }
}
