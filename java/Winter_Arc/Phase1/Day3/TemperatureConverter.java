package Winter_Arc.Phase1.Day3;
import java.util.Locale;
import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double temp , newTemp;
        String unit;

        System.out.print("Enter the temperature: ");
        temp = sc.nextDouble();

        System.out.println("Convert to Celsius or Fahrenheit (C or F): ");
        unit = sc.next().toUpperCase();


        newTemp = (unit.equals("C")) ? (temp - 32)* 5/9 : (temp * 5/9) +32;
        System.out.println(newTemp + "°" + unit);
        sc.close();

    }
}
