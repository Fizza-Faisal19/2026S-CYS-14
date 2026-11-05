package Week_7;
public class Account {

    private String number;
    private float amount;
    private Client ACholder;

    private static int count = 0;

    public Account(String number, float amount, Client ACholder) {
        count++;

        if (number == null || number.isEmpty()) {
            this.number = "ACC" + count;
        } else {
            this.number = number;
        }

        this.amount = amount;
        this.ACholder = ACholder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Client getACholder() {
        return ACholder;
    }

    public void setACholder(Client ACholder) {
        this.ACholder = ACholder;
    }

    public float withdraw(float amount) {
        if (amount > 0 && amount <= this.amount) {
            this.amount -= amount;
        } else {
            System.out.println("Invalid amount or insufficient balance!");
        }
        return this.amount;
    }

    public float deposit(float amount) {
        if (amount > 0) {
            this.amount += amount;
        } else {
            System.out.println("Invalid deposit amount!");
        }
        return this.amount;
    }

    public String toString() {
        return "Account Number: " + number + "\nBalance: " + amount + "\nAccount Holder: " +
                ACholder.getPersonDetails().getName();
    }
}