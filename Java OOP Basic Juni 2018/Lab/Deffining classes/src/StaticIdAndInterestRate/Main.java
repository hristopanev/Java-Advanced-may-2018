package StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Map<Integer, BankAccount> accounts = new HashMap<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] commandArgs = line.split(" ");

            switch (commandArgs[0]) {
                case "Create":
                    BankAccount acc = new BankAccount();
                    accounts.put(acc.getId(), acc);
                    System.out.println("Account ID" + acc.getId() + " created");
                    break;
                case "Deposit":
                    int id = Integer.valueOf(commandArgs[1]);
                    double amount = Double.valueOf(commandArgs[2]);
                    try {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %s to ID%s%n",
                                commandArgs[2], commandArgs[1]);
                    } catch (Exception e) {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterest(Double.parseDouble(commandArgs[1]));
                    break;
                case "GetInterest":
                    try {
                        System.out.printf("%.2f%n",
                                accounts.get(Integer.parseInt(commandArgs[1]))
                                        .getInterestRate(Integer.parseInt(commandArgs[2]))
                        );
                    } catch (Exception e) {
                        System.out.println("Account does not exist");
                    }

                    break;
            }
        }
    }
}
