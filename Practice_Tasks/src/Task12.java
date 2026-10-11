import java.util.*;
public class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String clean = "";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch))
            {
                clean = clean + Character.toLowerCase(ch);
            }
        }

        boolean palindrome = true;
        for (int i = 0; i < clean.length() / 2; i++)
        {
            if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i))
            {
                palindrome = false;
                break;
            }
        }
        if (palindrome)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}