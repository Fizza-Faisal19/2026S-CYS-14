import java.util.*;
public class Task36{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int start = 0;
        int maxStart = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        for (int end = 0; end < str.length(); end++)
        {
            char ch = str.charAt(end);
            while (set.contains(ch))
            {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(ch);
            int length = end - start + 1;
            if (length > maxLength)
            {
                maxLength = length;
                maxStart = start;
            }
        }
        String longest = str.substring(maxStart, maxStart + maxLength);
        System.out.println("Longest substring: " + longest);
        System.out.println("Length: " + maxLength);
    }
}