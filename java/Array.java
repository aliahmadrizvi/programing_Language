import java.util.Scanner;

class SingleArray {
    int size;
    int arr[];

    void inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the value : ");
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class Array {
    public static void main(String args[]) {
        SingleArray sa = new SingleArray();
        sa.inputArray();
        sa.printArray();
    }
}