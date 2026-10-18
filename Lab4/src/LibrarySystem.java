import java.util.Scanner;
class Book {
    String title;
    int shelf;
    // Constructor
    Book(String t, int s) {
        title = t;
        shelf = s;
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] space = {5, 5, 5};
        System.out.print("How many books you want to store: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Book title: ");
            String title = sc.nextLine();
            System.out.print("Shelf number (1,2 or 3): ");
            int shelf = sc.nextInt();
            sc.nextLine();
            if (shelf < 1 || shelf > 3) {
                System.out.println("Invalid shelf.");
            }
            else if (space[shelf - 1] == 0) {
                System.out.println("Shelf " + shelf + " is full.");
            }
            else {
                Book b = new Book(title, shelf);
                space[shelf - 1]--;
                System.out.println(b.title + " placed on shelf " + b.shelf);
                System.out.println("Space left on shelf " + shelf + ": " + space[shelf - 1]);
            }
        }
    }
}
