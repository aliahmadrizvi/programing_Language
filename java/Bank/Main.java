package Bank;

import java.util.Scanner;

public class Main {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            BankAccount BA1 = new BankAccount();
            System.out.println("Enter your Account Number: ");
            int acNumber = sc.nextInt();
            BA1.setAccountNumber(acNumber);

            System.out.println("Enter your Balance: ");
            double blc = sc.nextDouble();
            BA1.setBalance(blc);
            BA1.display();







        }
    }


