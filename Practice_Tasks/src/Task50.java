public class Task50 {
    public static void main(String[] args) {
        int[] digits = new int[1000];
        digits[0] = 1;
        int size = 1;
        for (int number = 2; number <= 50; number++)
        {
            int carry = 0;
            for (int i = 0; i < size; i++)
            {
                int value = digits[i] * number + carry;

                digits[i] = value % 10;
                carry = value / 10;
            }
            while (carry > 0) {
                digits[size] = carry % 10;
                carry = carry / 10;
                size++;
            }
        }
        System.out.println("50! = ");
        for (int i = size - 1; i >= 0; i--)
        {
            System.out.print(digits[i]);
        }
    }
}