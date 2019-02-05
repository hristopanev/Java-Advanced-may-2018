package bankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineArguments = scanner.nextLine().split("\\s+");
        String commands = lineArguments[0];


        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        while (!commands.equals("End")){
            String result = "";
            switch (commands){
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    result = "Account " + "ID"+account.getId() + " created";
                    break;
                case "Deposit":

                    int accountId = Integer.parseInt(lineArguments[1]);
                    double amount = Double.parseDouble(lineArguments[2]);

                    BankAccount currentAccount = accounts.get(accountId);
                    if (currentAccount == null){
                        result = "Account does not exist";
                        break;
                    }
                    currentAccount.deposit(amount);

                    accounts.put(accountId, currentAccount);

                    result = String.format("Deposited %.0f to ID%d", amount,  accountId);
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(lineArguments[1]);

                    BankAccount.setInterestRate(interestRate);

                    break;
                case "GetInterest":
                    int accountId2 = Integer.parseInt(lineArguments[1]);
                    int years = Integer.parseInt(lineArguments[2]);
                    BankAccount currentAccount2 = accounts.get(accountId2);

                    if (currentAccount2 == null){
                        result = "Account does not exist";
                        break;
                    }

                    double currentAcountInterest = currentAccount2.getInterestRate(years);
                    result = String.format("%.2f",currentAcountInterest);
                    break;
            }


            if (!result.isEmpty()){
                System.out.println(result);
            }
            lineArguments = scanner.nextLine().split("\\s+");
            commands = lineArguments[0];
        }
    }
}
