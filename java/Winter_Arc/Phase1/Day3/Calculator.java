package Winter_Arc.Phase1.Day3;
import  java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double firstNumber ;
        double secondNumber  ;
        double result = 0;
        char operator;
        boolean isRequided = false ;

        System.out.print("Enter the First Number: ");
        firstNumber = sc.nextDouble();

        System.out.print("Enter the operator(+ , - , * ,/ , ^): ");
        operator = sc.next().charAt(0);

        System.out.print("Enter the Second Number: ");
        secondNumber = sc.nextDouble();

        switch (operator){
            case '+' -> {
               result = firstNumber + secondNumber;
               isRequided = true;
                break;

            }
            case '-' -> {
                result = firstNumber - secondNumber;
                isRequided = true;
                break;
            }
            case '*' -> {
                result = firstNumber * secondNumber;
                isRequided = true;
                break;
            }
            case '/' -> {
                if( secondNumber == 0 ){
                    System.out.println("Zero cant divide");
                }
                else {
                    result = firstNumber / secondNumber;
                    isRequided = true;
                }
                break;
            }
            case '^' -> {
                result = Math.pow(firstNumber,secondNumber);
                isRequided = true;
            }
            default->{
                System.out.println("Invalid input ");
                isRequided = false;
            }




        }
        if(isRequided){
            System.out.println("Result is "+result);
        }


    }
}
