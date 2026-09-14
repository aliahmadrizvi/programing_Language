package Winter_Arc.Phase1.Day2;
import java.util.*;
public class CompoundCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        double principalAmount = sc.nextDouble();
        System.out.print("Enter the interest rate (in %): ");
        double interestRate = sc.nextDouble()/100;
        System.out.print("Enter the # of times compounded per year: ");
        int yearCompounded = sc.nextInt();
        System.out.print("for how many years: ");
        int year = sc.nextInt();


        double amount = principalAmount*Math.pow(1+(interestRate/yearCompounded),yearCompounded*year);

        System.out.printf("The amount after %d years is: $%.2f%n", year, amount);
        sc.close();

    }
}
