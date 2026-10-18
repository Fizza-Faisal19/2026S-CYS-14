import java.util.Scanner;
class Walls {
    String flavor;
    int scoops;
    String coneType;
    int price;


    Walls() {
        flavor = "Vanilla";
        scoops = 1;
        coneType = "Sugar";
        calculatePrice();
    }
    Walls(String f, int s, String c) {
        flavor = f;
        scoops = s;
        coneType = c;
        calculatePrice();
    }
    void calculatePrice() {
        price = scoops * 75;

        if (coneType.equalsIgnoreCase("Waffle")) {
            price = price + 40;
        }
    }
    void display() {
        System.out.println("Flavor: " + flavor);
        System.out.println("Scoops: " + scoops);
        System.out.println("Cone: " + coneType);
        System.out.println("Total price: Rs. " + price);
    }
}
public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Chocolate");
        System.out.println("2. Vanilla");
        System.out.println("3. Strawberry");
        System.out.println("4. Mango");
        System.out.println("5. Tutti Fruit");
        System.out.println("6. Almond Crunch");
        System.out.println("7. Coffee");
        System.out.print("Choose flavor (1-7): ");
        int choice = sc.nextInt();
        sc.nextLine();
        String flavor;
        switch (choice) {
            case 1:
                flavor = "Chocolate";
                break;
            case 2:
                flavor = "Vanilla";
                break;
            case 3:
                flavor = "Strawberry";
                break;
            case 4:
                flavor = "Mango";
                break;
            case 5:
                flavor = "Tutti Fruit";
                break;
            case 6:
                flavor = "Almond Crunch";
                break;
            case 7:
                flavor = "Coffee";
                break;
            default:
                System.out.println("Invalid flavor!");
                sc.close();
                return;
        }
        System.out.print("Enter number of scoops: ");
        int scoops = sc.nextInt();
        sc.nextLine();
        if (scoops <= 0) {
            System.out.println("Scoops must be positive!");
            sc.close();
            return;
        }
        System.out.print("Enter cone type (Sugar/Waffle): ");
        String cone = sc.nextLine();
        if (!cone.equalsIgnoreCase("Sugar")
                && !cone.equalsIgnoreCase("Waffle")) {
            System.out.println("Invalid cone type!");
            sc.close();
            return;
        }
        Walls iceCream = new Walls(flavor, scoops, cone);
        iceCream.display();
        sc.close();
    }
}
