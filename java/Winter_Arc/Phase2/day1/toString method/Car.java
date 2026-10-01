
public class Car {
    String model;
    String make;
    int year;
    String color;

    Car(String model , String make, int year, String color){
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString(){
        return this.color+" "+this.year+" "+this.make+" "+this.model;
    }
}
