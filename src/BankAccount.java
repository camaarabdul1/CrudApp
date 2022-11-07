
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {

    ArrayList<Transaction> transactionsList = new ArrayList<>();


    Scanner scan = new Scanner(System.in);

    Scanner input = new Scanner(System.in);

    public void createTransaction() {
        System.out.println("enter new name");
        String name = scan.nextLine();
        System.out.println("enter description");
        String description = scan.nextLine();
        System.out.println("enter accounttype");
        String accounttype = scan.nextLine();
        System.out.println("enter price");
        double price = scan.nextDouble();
        scan.nextLine();

        Transaction newtransaction = new Transaction(name, accounttype, description, price);
        transactionsList.add(newtransaction);
    }

    public void readTransactions() {
        System.out.println("Here are your transactions");
        for (Transaction transaction : this.transactionsList) {
            transaction.print();
        }
    }

    public void updateTransaction() {
        System.out.println("Enter name of transaction to update: ");
        String nameoftransaction = input.nextLine();
        for(Transaction transaction : this.transactionsList){
            if(transaction.getName().equals(nameoftransaction)){
                System.out.println("enter new name");
                String name = scan.nextLine();
                System.out.println("enter description");
                String description = scan.nextLine();
                System.out.println("enter accounttype");
                String accounttype = scan.nextLine();
                System.out.println("enter price");
                double price = scan.nextDouble();

                transaction.setName(name);
                transaction.setDescription(description);
                transaction.setAccounttype(accounttype);
                transaction.setPrice(price);

                break;
            }
        }
    }

    public void deleteTransaction( ){

        System.out.println("Enter name of transaction to update: ");
        String nameOfTransactionToDelete = input.nextLine();


        Transaction transactionToDelete;

        for(Transaction transaction : this.transactionsList){
            if(transaction.getName().equals(nameOfTransactionToDelete)){
                transactionToDelete = transaction;
                this.transactionsList.remove(transaction);
                break;
            }
        }
    }
}
