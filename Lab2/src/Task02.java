import java.util.Scanner;
public class Task02 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        System.out.println("Details: " + name + "," + age);
    }
}
