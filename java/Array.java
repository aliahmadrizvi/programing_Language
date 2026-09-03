import java.util.Scanner;

class DoubleArray {
    int size;
    int darr[][];

    void inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        size = sc.nextInt();

        darr = new int[size][size];
        for (int i = 0; i < darr.length; i++) {
            for (int j = 0; j < darr.length; j++) {
                System.out.print("Enter the value : ");
                darr[i][j] = sc.nextInt();
            }
        }
        sc.close();

    }

    void diagonal() {
        for (int i = 0; i < darr.length; i++) {
            for (int j = 0; j < darr.length; j++) {
                if (i == j || i + j == (darr.length - 1)) {
                    System.out.print(darr[i][j] + " ");
                }
            }
        }
        System.out.println();
    }

    void printArray() {
        for (int i = 0; i < darr.length; i++) {
            for (int j = 0; j < darr.length; j++) {
                System.out.print(darr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

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
        // SingleArray sa = new SingleArray();
        // sa.inputArray();
        // sa.printArray();
        DoubleArray obj = new DoubleArray();
        obj.inputArray();
        obj.printArray();
        obj.diagonal();

    }
}