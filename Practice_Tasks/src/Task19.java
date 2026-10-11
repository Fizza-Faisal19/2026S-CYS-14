public class Task19 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 40, 30};
        int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            boolean duplicate = false;
            for (int j = 0; j < count; j++)
            {

                if (arr[i] == result[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate)
            {
                result[count] = arr[i];
                count++;
            }
        }
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < count; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}