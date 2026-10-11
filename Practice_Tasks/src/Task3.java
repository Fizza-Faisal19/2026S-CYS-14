public class Task3 {
    public static void main(String[] arg) {
        int a = 8;
        int b = 19;
        int c = 20;
        if ((a > b && a < c) || (a < b && a > c)) {
            System.out.println("Median: " + a);
        } else if ((b > a && b < c) || (b < a && b > c)) {
            System.out.println("Median: " + b);
        } else {
            System.out.println("Median: " + c);
        }
    }
}
