import java.util.*;
public class Task33 {
    static void permute(String str, String result) {
        if (str.length() == 0)
        {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i)
                    + str.substring(i + 1);
            permute(remaining, result + ch);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Permutations:");
        permute(str, "");
    }
}