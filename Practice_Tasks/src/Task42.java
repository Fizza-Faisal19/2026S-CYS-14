import java.util.*;
public class Task42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter sorted elements of first array:");
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.println("Enter sorted elements of second array:");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m)
        {
            if (a[i] <= b[j])
            {
                result[k] = a[i];
                i++;
            }
            else
            {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < n)
        {
            result[k] = a[i];
            i++;
            k++;
        }
        while (j < m)
        {
            result[k] = b[j];
            j++;
            k++;
        }
        System.out.println("Merged sorted array:");
        for (int x = 0; x < result.length; x++)
        {
            System.out.print(result[x] + " ");
        }
    }
}