public class JTime {
    int hour;
    int minute;
    int second;
    // Constructor 1
    JTime() {
        hour = 0;
        minute = 0;
        second = 0;
    }
    // Constructor 2
    JTime(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
    }
    // Constructor 3
    JTime(int totalSeconds) {
        totalSeconds = totalSeconds % 86400;
        hour = totalSeconds / 3600;
        minute = (totalSeconds % 3600) / 60;
        second = totalSeconds % 60;
    }
    int toSeconds() {
        return hour * 3600 + minute * 60 + second;
    }
    //Find elapsed time in seconds
    int elapsedSeconds(JTime other) {
        return Math.abs(this.toSeconds() - other.toSeconds());
    }
    //Return elapsed time as another JTime object
    JTime elapsedTime(JTime other) {
        int difference = elapsedSeconds(other);
        return new JTime(difference);
    }
    void display() {
        System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
    }
    public static void main(String[] args) {
        JTime t1 = new JTime(10, 20, 30);
        JTime t2 = new JTime(12, 25, 40);
        System.out.print("First time: ");
        t1.display();
        System.out.print("Second time: ");
        t2.display();
        System.out.println("Elapsed seconds: " + t1.elapsedSeconds(t2));
        System.out.print("Elapsed time: ");
        t1.elapsedTime(t2).display();
        JTime t3 = new JTime(3665);
        System.out.print("Time from 3665 seconds: ");
        t3.display();
    }
}
