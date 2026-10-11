import java.util.Scanner;
import java.util.Random;
public class Task03 {
    static int aliX = 0;
    static int aliY = 0;
    static int hasanX = 0;
    static int hasanY = 0;
    static boolean isObstacle(int x, int y) {
        if (x == 1 && y == 2) return true;
        if (x == 2 && y == 2) return true;
        if (x == 3 && y == 1) return true;
        return false;
    }
    static void moveAli(char direction) {
        int newX = aliX;
        int newY = aliY;
        if (direction == '^') {
            newY++;
        }
        else if (direction == 'v') {
            newY--;
        }
        else if (direction == '>') {
            newX++;
        }
        else if (direction == '<') {
            newX--;
        }
        else {
            System.out.println("Invalid direction.");
            return;
        }
        if (isObstacle(newX, newY)) {
            System.out.println("Ali encounters a hurdle!");
        }
        else {
            aliX = newX;
            aliY = newY;
        }
        System.out.println("Ali is at = (" + aliX + " : " + aliY + ")");
    }
    static void moveHasan(Random random) {
        char[] directions = {'^', 'v', '<', '>'};
        char direction =
                directions[random.nextInt(4)];
        int newX = hasanX;
        int newY = hasanY;
        if (direction == '^') {
            newY++;
        }
        else if (direction == 'v') {
            newY--;
        }
        else if (direction == '>') {
            newX++;
        }
        else {
            newX--;
        }
        if (isObstacle(newX, newY)) {
            System.out.println("Hasan encounters hurdle at (" + newX + " : " + newY + ")");
        }
        else {
            hasanX = newX;
            hasanY = newY;
        }
        System.out.println("Hasan is at = (" + hasanX + " : " + hasanY + ")");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Starting: Ali = (0 : 0), Hasan = (0 : 0)");
        while (true) {
            System.out.print("Ali, where should I go? (^ v < >, q to quit): ");
            char direction = sc.next().charAt(0);
            if (direction == 'q' || direction == 'Q') {
                break;
            }
            moveAli(direction);
            moveHasan(random);
        }
        System.out.println("Walking simulation ended.");
        sc.close();
    }
}