package Week_7;
import java.util.ArrayList;

public class Client {

    private String id;
    private Person PersonDetails;
    private ArrayList<Account> AcList;

    private static int count = 0;

    public Client(Person PersonDetails) {
        count++;
        this.id = "C" + count;
        this.PersonDetails = PersonDetails;
        AcList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPersonDetails() {
        return PersonDetails;
    }

    public void setPersonDetails(Person PersonDetails) {
        this.PersonDetails = PersonDetails;
    }

    public ArrayList<Account> getAcList() {
        return AcList;
    }

    public void setAcList(ArrayList<Account> AcList) {
        this.AcList = AcList;
    }

    public float totalAmount() {
        float total = 0;

        for (Account a : AcList) {
            total += a.getAmount();
        }

        return total;
    }

    public void addAccount(Account a) {
        if (a != null && !AcList.contains(a)) {
            AcList.add(a);
        }
    }

    public float withdraw(float amount, String accNo) {
        for (Account a : AcList) {
            if (a.getNumber().equals(accNo)) {
                return a.withdraw(amount);
            }
        }

        System.out.println("Account not found!");
        return -1;
    }

    public float deposit(float amount, String accNo) {
        for (Account a : AcList) {
            if (a.getNumber().equals(accNo)) {
                return a.deposit(amount);
            }
        }

        System.out.println("Account not found!");
        return -1;
    }

    @Override
    public String toString() {
        String result = "\nClient ID: " + id;
        result += "\n" + PersonDetails.toString();
        result += "\nAccounts:";

        for (Account a : AcList) {
            result += "\n" + a.toString();
        }

        return result;
    }
}