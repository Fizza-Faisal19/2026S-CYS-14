public class Task14 {
    public static void main(String[] args) {
        int[] arr = {10, 50, 30, 50, 20, 40, 25, 35, 15, 45};
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] > secondLargest && arr[i] != largest)
            {
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest: " + largest);
        System.out.println("Second largest: " + secondLargest);
    }
}