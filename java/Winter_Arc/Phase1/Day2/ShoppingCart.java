package Winter_Arc.Phase1.Day2;
import java.util.Scanner;
public class ShoppingCart {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("What item would you like to buy?: ");
        String item = sc.nextLine();
        System.out.print("What is the price for each item?: ");
        double price = sc.nextDouble();
        System.out.print("How many would you like?: ");
        int count = sc.nextInt();

        System.out.printf("\nYou have bought %d %ss\n",count,item);
        System.out.println("Your total is $"+price*count);
        sc.close();

    }
}
