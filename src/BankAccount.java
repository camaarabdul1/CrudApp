import java.io.*;
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
        for (Transaction transaction : this.transactionsList) {
            if (transaction.getName().equals(nameoftransaction)) {
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

    public void deleteTransaction() {

        System.out.println("Enter name of transaction to update: ");
        String nameOfTransactionToDelete = input.nextLine();


        Transaction transactionToDelete;

        for (Transaction transaction : this.transactionsList) {
            if (transaction.getName().equals(nameOfTransactionToDelete)) {
                transactionToDelete = transaction;
                this.transactionsList.remove(transaction);
                break;
            }
        }
    }


    public void saveData() {
        try {
            FileOutputStream FileOut = new FileOutputStream("object.ser");
            //responsible for opening a connection to a file
            ObjectOutputStream ObjectOut = new ObjectOutputStream(FileOut);
            //responsible for streaming data from object into a file
            ObjectOut.writeObject(transactionsList);



            ObjectOut.close();
            // close it once we are done with the file
            FileOut.close();
            // close it once we are done with the file
            System.out.println("Serialized data is saved!");


        } catch (IOException i) {
            i.printStackTrace();
            // history of all the methods that were called - allows us to see where the code went wrong.
            //principle of a stack is similar to pringles - last in, first out
        }

    }


    public void loadData() {

       Transaction t = null; // this create an object of type employee to receive data from file or return

        try {
            // read object from a file
            FileInputStream FileIn = new FileInputStream("object.ser");
            // create a connect to a file
            ObjectInputStream ObjectIn = new ObjectInputStream(FileIn);

            // method for deserialization for an object
            t = (Transaction) ObjectIn.readObject();
            // ^ read object and convert data to type Transaction

            ObjectIn.close();
            FileIn.close();

            System.out.println("Object has been deserialized");
            System.out.println(t.getName());

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }


    }

}





