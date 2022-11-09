import java.util.Scanner;

// Main should run our program and present transactions for user input
public class Main {

    //Class attributes
    static Scanner scan = new Scanner(System.in);

    //Creating a new instance of our bank account
    static BankAccount bankAccount = new BankAccount();

    public static void main(String[] args){
        int option = 0;

        do{
            System.out.println("1. Create a transaction");
            System.out.println("2. Read transactions");
            System.out.println("3. Update a transaction");
            System.out.println("4. Delete a transaction");
            System.out.println("5. Save Data");
            System.out.println("6. Load Data");
            System.out.println("7. Quit");


            option = scan.nextInt();

            switch(option){
                case 1:
                    bankAccount.createTransaction();
                    break;
                case 2:
                    bankAccount.readTransactions();
                    break;
                case 3:
                    bankAccount.updateTransaction();
                    break;
                case 4:
                    bankAccount.deleteTransaction();
                    break;
                case 5:
                    bankAccount.saveData();
                    break;
                case 6:
                    bankAccount.loadData();
                    break;


            }
        }
        while(option != 7);
    }



    }

