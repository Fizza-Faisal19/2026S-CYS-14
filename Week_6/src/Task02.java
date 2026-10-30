import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

class Walker {
    protected int x = 0;
    protected int y = 0;
    static Set<String> obstacles = new HashSet<>();
    boolean move(int newX, int newY) {
        String position = newX + ":" + newY;
        if (obstacles.contains(position)) {
            System.out.println("Walker encounters hurdle at [" + position + "]");
            return false;
        }
        x = newX;
        y = newY;
        return true;
    }
    void printLocation(String name) {
        System.out.println(
                name + " is at = " + x + " : " + y
        );
    }
}
class DirectedWalker extends Walker {
    void walk(char direction) {
        int newX = x;
        int newY = y;
        switch (direction) {
            case '^':
                newY++;
                break;
            case 'v':
                newY--;
                break;
            case '>':
                newX++;
                break;
            case '<':
                newX--;
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }
        move(newX, newY);
    }
}
class RandomWalker extends Walker {
    private Random random = new Random();
    void walk() {
        int direction = random.nextInt(4);
        int newX = x;
        int newY = y;
        switch (direction) {
            case 0:
                newY++;
                break;
            case 1:
                newY--;
                break;
            case 2:
                newX++;
                break;
            case 3:
                newX--;
                break;
        }
        move(newX, newY);
    }
}

public class Task02{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DirectedWalker ali = new DirectedWalker();
        RandomWalker hassan = new RandomWalker();

        // Add a shared obstacle
        Walker.obstacles.add("1:2");

        System.out.println("Starting: Ali's Location is = 0 : 0 " + "Hassan's Location is = 0 : 0");

        System.out.println("Hassan has Random Movement, Ali follows order");

        for (int i = 0; i < 5; i++) {
            System.out.print("Ali: Where should I go now (^, v, <, >): ");
            char direction = input.next().charAt(0);
            ali.walk(direction);
            ali.printLocation("Ali");
            hassan.walk();
            hassan.printLocation("Hassan");
            System.out.println();
        }
        input.close();
    }
}