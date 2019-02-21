package Vlog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Vlogger> vloggers = new HashMap<>();

        while (line.equalsIgnoreCase("Statistics")){
            String[] tokens = line.split("\\s+");

            if (tokens[1].equalsIgnoreCase("joined")){
                if (!vloggers.containsKey(tokens[0])){line = scanner.nextLine(); continue;}
                Vlogger vlogger = new Vlogger(tokens[0]);
                vloggers.put(tokens[0], vlogger);

            }else {
                Vlogger follower = vloggers.get(tokens[0]);
                Vlogger followed = vloggers.get(tokens[2]);

                if (follower == null || followed == null){
                    line = scanner.nextLine();
                    continue;
                }

                followed.follow(follower);
                follower.addFollowing(followed);

                vloggers.put(followed.getName(), followed);
                vloggers.put(follower.getName(), follower);
            }

            line = scanner.nextLine();
        }

        List<Vlogger> sortedVlogger = vloggers.values()
                .stream()
                .sorted((f, s) -> {
                    int diff = s.getFollowerCount() - f.getFollowerCount();
                    if (diff == 0){
                        diff = f.getFollowingCount() - s.getFollowingCount();
                    }

                    return diff;
                })
        .collect(Collectors.toList());

        System.out.print("1. " + sortedVlogger.get(0).toFullString());

        for (int i = 1; i < sortedVlogger.size(); i++) {
            System.out.println((i + 1) + ". " + sortedVlogger.get(i).toBasicString());

        }
    }
}
