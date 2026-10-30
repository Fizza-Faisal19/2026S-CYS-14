class Counter {
    private int value;
    private int maximum;

    Counter(int max) {
        maximum = max;
        value = 0;
    }
    void set(int number) {
        value = number;
    }
    int getValue() {
        return value;
    }
    void increment() {
        if (value == maximum) {
            value = 0;
        } else {
            value++;
        }
    }
    public String toString() {
        if (value < 10) {
            return "0" + value;
        }
        return "" + value;
    }
}
class DigitalTimer {
    private Counter hours;
    private Counter minutes;
    // Default constructor
    public DigitalTimer() {
        hours = new Counter(23);
        minutes = new Counter(59);
    }
    // Parameterized constructor
    public DigitalTimer(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Invalid time");
        }
        hours = new Counter(23);
        minutes = new Counter(59);

        hours.set(h);
        minutes.set(m);
    }
    // Display the current time
    public String toString() {
        return hours.toString() + ":" + minutes.toString();
    }
    // Increase time by one minute
    public void tick() {
        minutes.increment();
        if (minutes.getValue() == 0) {
            hours.increment();
        }
    }
    // Set a new time
    public void set(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Invalid time");
        }
        hours.set(h);
        minutes.set(m);
    }
}
public class Main {
    public static void main(String[] args) {
        DigitalTimer timer = new DigitalTimer();
        System.out.println(timer);
        timer.set(10, 45);
        System.out.println(timer);
        timer.tick();
        System.out.println(timer);
        DigitalTimer timer2 = new DigitalTimer(23, 59);
        timer2.tick();
        System.out.println(timer2);
    }
}
