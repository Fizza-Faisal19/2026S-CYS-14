class Engine{
    void start(){
        System.out.println("Engine is started");
    }
}
class Car {
    private Engine s1;
//constructor
    public Car(Engine s1) {
        this.s1 = s1;
    }
    void drive(){
        s1.start();
        System.out.println("Car is started");
    }
}
public class Task03{
    public static void main(String[] args) {
        Engine b = new Engine();
        Car a = new Car(b);
        a.drive();
    }
}
