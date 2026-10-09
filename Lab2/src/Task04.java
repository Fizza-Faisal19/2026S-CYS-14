import java.util.Scanner;
public class Task04 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Minutes: ");
        int minutes = sc.nextInt();
        int hour = (minutes/60) % 12;
        int reminutes = minutes % 60;
        System.out.println("Time is: " + hour + ":" + reminutes);
    }
}
