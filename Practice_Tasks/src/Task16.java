import java.util.*;
public class Task16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an odd number: ");
        int n = sc.nextInt();
        if (n % 2 == 0)
        {
            System.out.println("Please enter an odd number.");
            return;
        }
        int mid = n / 2;
        for (int i = 0; i <= mid; i++)
        {
            for (int j = 0; j < mid - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++)
            {
                if (j == 0 || j == 2 * i)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = mid - 1; i >= 0; i--)
        {
            for (int j = 0; j < mid - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++)
            {

                if (j == 0 || j == 2 * i) {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}