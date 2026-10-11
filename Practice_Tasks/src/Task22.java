import java.util.*;
public class Task22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("Enter 9 numbers:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Transpose:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
        boolean symmetric = true;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    symmetric = false;
                }
            }
        }
        if (symmetric)
        {
            System.out.println("Matrix is symmetric.");
        }
        else
        {
            System.out.println("Matrix is not symmetric.");
        }
    }
}