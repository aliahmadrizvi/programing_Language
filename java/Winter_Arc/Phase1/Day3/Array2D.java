package Winter_Arc.Phase1.Day3;

public class Array2D {
    public static <string> void main(String[] args){
        String[] fruits = {"Apple","Banana","Orange","Pineapple","Papaya"};
        String[] vegeTables = {"Potato","Tomato","Botte Guard","Cabbage"};
        String[] drinks = {"Coca Cola","Fanta"};

        String[][]  groceries = {fruits,vegeTables,drinks};

        for(String[] foods : groceries ){
            for(String food : foods){
                System.out.print(food+" ");
            }
            System.out.println();
        }


    }
}
