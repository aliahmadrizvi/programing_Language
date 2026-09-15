package Winter_Arc.Phase1.Day3;
import java.util.Scanner;
public class BankingProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double amount;
        int choice;

        while(isRunning){
            System.out.println("\n********************");
            System.out.println("Banking Program");
            System.out.println("*********************");
            System.out.println("1.Show Balance\n2.Deposit\n3.Withdraw\n4.Exit");
            System.out.print("Enter your Choice(1-4): ");
            choice = sc.nextInt();
            switch (choice){
                case 1 -> {
                    showBalance();
                }
                case 2 ->{
                    System.out.print("Add money: $");
                    amount = sc.nextDouble();
                    deposit(amount);

                }
                case 3 ->{
                    System.out.print("Withdraw: $");
                    amount = sc.nextDouble();
                    withdraw(amount);

                }
                case 4->{
                    isRunning = false;

                }
                default -> {
                    System.out.println("invalid choice");
                }

            }

        }
        sc.close();

    }
    static double balance;
    static boolean isRunning = true;
    static void showBalance(){
        System.out.printf("Current Balance: $%.2f",balance);
    }
    static void deposit(double amount){
        if(amount>0){

        balance = balance + amount;
        }
        else{
            System.out.println("Invalid Input");
        }
    }
    static void withdraw(double amount){
        if(amount>0 && amount <= balance){

            balance = balance - amount;
        }
        else{
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}
