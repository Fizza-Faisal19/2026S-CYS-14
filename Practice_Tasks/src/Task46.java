import java.util.Scanner;
public class Task46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int currentSum = arr[0];
        int maxSum = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > currentSum + arr[i])
            {
                currentSum = arr[i];
                tempStart = i;
            }
            else
            {
                currentSum = currentSum + arr[i];
            }
            if (currentSum > maxSum)
            {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Start index: " + start);
        System.out.println("End index: " + end);
    }
}