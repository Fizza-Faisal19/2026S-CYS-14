import java.util.*;
public class Task35 {
    static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;
        while (low <= high)
        {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
                System.out.println("Steps taken: " + steps);
                return;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        System.out.println("Element not found");
        System.out.println("Steps taken: " + steps);
    }
    // Binary search for first occurrence
    static void firstOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;
        int steps = 0;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;  // Continue searching left
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        if (result != -1)
        {
            System.out.println("First occurrence at index: " + result);
            System.out.println("Steps taken: " + steps);
        }
        else
        {
            System.out.println("Element not found");
            System.out.println("Steps taken: " + steps);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("Normal Binary Search:");
        binarySearch(arr, 2);
        System.out.println();
        System.out.println("First Occurrence Binary Search:");
        firstOccurrence(arr, 2);
    }
}