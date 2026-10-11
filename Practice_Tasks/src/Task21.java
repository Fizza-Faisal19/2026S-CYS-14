public class Task21 {
    static int multiplications = 0;
    static long power(int x, int n) {
        if (n == 0)
        {
            return 1;
        }
        long half = power(x, n / 2);
        if (n % 2 == 0)
        {
            multiplications++;
            return half * half;
        }
        else
        {
            multiplications += 2;
            return half * half * x;
        }
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 30;
        long result = power(x, n);
        System.out.println("Result: " + result);
        System.out.println("Multiplications: " + multiplications);
    }
}