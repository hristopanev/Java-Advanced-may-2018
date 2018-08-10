package DefiningClass;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        BankAcaount account = new BankAcaount();

        account.setId(1);
        account.deposit(50);
        System.out.println(account.getBalance());

        account.withdraw(100);
        System.out.println(account.getBalance());

        System.out.println(account);
    }

}
