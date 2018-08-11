package banckAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAcaount> accounts = new HashMap<>();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] commandsArgs = line.split(" ");
            int id = Integer.parseInt(commandsArgs[1]);

            switch (commandsArgs[0]) {
                case "Create":
                    executeCreateCommand(accounts, id);
                    break;
                case "Deposit":
                    executeDepositCommand(accounts.get(id), commandsArgs[2]);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(accounts.get(id), commandsArgs[2]);
                    break;
                case "Print":
                    executePrintCommand(accounts, id);
                    break;
            }
        }
    }

    private static void executePrintCommand(Map<Integer, BankAcaount> accounts, int id) {
        if (accounts.get(id) == null){
            System.out.println("Account does not exist");
            return;
        }
        System.out.println(accounts.get(id));
    }

    private static void executeWithdrawCommand(BankAcaount acc1, String commandsArg) {
        double withdrawAmount = Double.parseDouble(commandsArg);
        BankAcaount acc = acc1;
        if (acc != null ){
            if (acc.getBalance() < withdrawAmount){
                System.out.println("Insufficient balance");
            }else {
                acc.withdraw(withdrawAmount);
            }
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeDepositCommand(BankAcaount bankAcaount, String commandsArg) {
        double depositAmount = Double.parseDouble(commandsArg);
        if (bankAcaount == null){
            System.out.println("Account does not exist");
            return;
        }
        bankAcaount.deposit(depositAmount);
    }

    private static void executeCreateCommand(Map<Integer, BankAcaount> accounts, int id) {
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAcaount ba = new BankAcaount();
            ba.setId(id);
            accounts.put(id, ba);
        }
    }
}
