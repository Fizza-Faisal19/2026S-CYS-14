import java.util.Scanner;
public class Task05 {
    public static void main(String[] arg) {
        int[] array = {2, 4, 5, 3, 6, 32, 78, 6, 54, 9, 8, 12};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Start num: ");
        int S = sc.nextInt();
        System.out.println("Enter End num: ");
        int E = sc.nextInt();
        System.out.println("Enter increament num: ");
        int I = sc.nextInt();
        for (int i = S; i < E; i += 1){
            System.out.println(array[i]);
        }
    }
}
