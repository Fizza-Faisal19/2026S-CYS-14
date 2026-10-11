import java.util.Scanner;
public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' ||
                    ch == 'O' || ch == 'U') {
                vowels++;
            }
            else if (ch >= '0' && ch <= '9')
            {
                digits++;
            }
            else if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z'))
            {
                consonants++;
            }
            else {
                other++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Other characters: " + other);
    }
}