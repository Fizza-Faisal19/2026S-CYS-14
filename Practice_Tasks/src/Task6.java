import java.util.*;
public class Task6 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        while (n > 0)
        {
            int digit = n % 10;
            System.out.print(digit);
            n = n / 10;
        }
    }
}
