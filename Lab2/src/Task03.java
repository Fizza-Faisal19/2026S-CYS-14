import java.util.Scanner;
public class Task03 {
   public static void main(String[] arg){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a number:" );
       int num = sc.nextInt();
       int hour = num/60;
       int minutes = num%60;
       System.out.println("Time is: " + hour + ":1" + minutes);
    }
}
