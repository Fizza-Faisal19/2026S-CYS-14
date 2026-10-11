import java.util.*;
public class Task40 {
    static int moves = 0;
    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1)
        {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            moves++;
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moves++;
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        moves = 0;
        towerOfHanoi(n, 'A', 'B', 'C');
        int expectedMoves = (int) Math.pow(2, n) - 1;
        System.out.println("\nTotal moves: " + moves);
        System.out.println("Expected moves: " + expectedMoves);
        if (moves == expectedMoves)
        {
            System.out.println("Verification successful.");
        }
        else
        {
            System.out.println("Verification failed.");
        }
    }
}