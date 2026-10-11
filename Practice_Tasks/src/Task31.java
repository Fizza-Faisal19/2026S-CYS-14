import java.util.*;
public class Task31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++)
        {
            triangle[i] = new int[i + 1];
        }
        for (int i = 0; i < n; i++)
        {
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++)
            {
                triangle[i][j] = triangle[i - 1][j - 1]
                        + triangle[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int space = 0; space < n - i - 1; space++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < triangle[i].length; j++)
            {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}