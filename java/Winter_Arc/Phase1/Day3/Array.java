package Winter_Arc.Phase1.Day3;
import java.util.Scanner;
public class Array {
    static boolean linearSearch(String[] arr, String target){
        for(int i = 0 ; i<arr.length;i++){
           if(arr[i].equals(target)){
               return true;
           }

        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fruits ;
        int size;
        String Search;
        System.out.println("Enter the size: ");
        size = sc.nextInt();

        fruits = new String[size];
        sc.nextLine();

        for(int i = 0 ; i<fruits.length;i++){
            System.out.print("Enter the Fruit name: ");
            fruits[i] = sc.nextLine();
        }

        for(String fruit : fruits){
            System.out.println(fruit);

        }
        System.out.println("Search fruit here: ");
        Search = sc.nextLine();

        if(linearSearch(fruits,Search)){
            System.out.println("Available");
        }
        else{
            System.out.println("Its not available right now ");
        }

    }


}
