package Winter_Arc.Phase1.Day2;
import java.util.Scanner;
public class WeightConvertor {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            double weight;
            double newWeight;
            int choice;
            System.out.println("Weight Conversion Program");
            System.out.println("1.Lbs to kgs");
            System.out.println("2. Kgs to Lbs");

            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the weight in lbs: ");
                    weight = sc.nextDouble();
                    newWeight = weight * 0.4536;
                    System.out.printf("The new weight in kgs is: %.2f Kgs",newWeight);
                }
                case 2 -> {
                    System.out.print("Enter the weight in kgs: ");
                    weight = sc.nextDouble();
                    newWeight = weight * 2.20462;
                    System.out.printf("The new weight in lbs is: %.2f lbs",newWeight);
                }
                default -> System.out.println("Invalid Choice ");
            }
        }

    }
}
