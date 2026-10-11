import java.util.*;
public class Task28 {
    static String compress(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i + 1) == current)
            {
                count++;
                i++;
            }
            result += current + "" + count;
        }
        return result;
    }
    static String decompress(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            i++;
            int count = 0;
            while (i < str.length() && Character.isDigit(str.charAt(i)))
            {
                count = count * 10 + (str.charAt(i) - '0');
                i++;
            }
            i--;
            for (int j = 0; j < count; j++)
            {
                result += ch;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String compressed = compress(str);
        System.out.println("Compressed: " + compressed);
        String decompressed = decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}