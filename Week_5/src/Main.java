import java.util.Scanner;
class weekdays {
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
    int dayNumber;
    weekdays(String day) {
        setDay(day);
    }
    void setDay(String day) {
        for (int i = 0; i < 7; i++) {
            if (days[i].equalsIgnoreCase(day)) {
                dayNumber = i;
                return;
            }
        }
        System.out.println("Invalid day!");
        dayNumber = 0;
    }
    void printDay() {
        System.out.println("Current day: " + days[dayNumber]);
    }
    String getDay() {
        return days[dayNumber];
    }
    String nextDay() {
        return days[(dayNumber + 1) % 7];
    }
    String previousDay() {
        return days[(dayNumber + 6) % 7];
    }
    String addDays(int number) {
        int newDay = (dayNumber + number % 7) % 7;
        return days[newDay];
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a day: ");
        String day = sc.nextLine();
        weekdays d = new weekdays(day);
        d.printDay();
        System.out.println("Day returned: " + d.getDay());
        System.out.println("Next day: " + d.nextDay());
        System.out.println("Previous day: " + d.previousDay());
        System.out.print("Enter number of days to add: ");
        int number = sc.nextInt();
        System.out.println("New day: " + d.addDays(number));
        sc.close();
    }
}
