import java.util.*;
public class Task23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();
        int binary = 0;
        int place = 1;
        int temp = n;
        while (temp > 0)
        {
            int remainder = temp % 2;
            binary = binary + remainder * place;
            place = place * 10;
            temp = temp / 2;
        }
        System.out.println("Binary using loop: " + binary);
        System.out.print("Binary using recursion: ");
        printBinary(n);
    }
    static void printBinary(int n) {
        if (n > 1)
        {
            printBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}