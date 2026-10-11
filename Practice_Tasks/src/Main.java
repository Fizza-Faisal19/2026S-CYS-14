import java.util.*;
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integar: ");
        int num = sc.nextInt();
        if ((num / 2) * 2 == num)
        {
            System.out.println("Number is Even");
        }
        else
        {
            System.out.println("Number is Odd");
        }
    }
}
