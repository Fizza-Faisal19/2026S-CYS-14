package Week_7;
import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Client> ClList;
    private ArrayList<Account> AcList;

    public Bank(String name) {
        this.name = name;
        ClList = new ArrayList<>();
        AcList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Client> getClList() {
        return ClList;
    }

    public void setClList(ArrayList<Client> ClList) {
        this.ClList = ClList;
    }

    public ArrayList<Account> getAcList() {
        return AcList;
    }

    public void setAcList(ArrayList<Account> AcList) {
        this.AcList = AcList;
    }

    // Add client
    public Client addClient(Person p) {
        Client c = new Client(p);
        ClList.add(c);
        return c;
    }

    // Add account
    public Account addAccount(String id, float amount, Client c) {
        if (c == null || !ClList.contains(c)) {
            System.out.println("Client not found!");
            return null;
        }

        Account a = new Account(id, amount, c);

        AcList.add(a);
        c.addAccount(a);
        return a;
    }

    // Search account
    public Account searchAccount(String id) {
        for (Account a : AcList) {
            if (a.getNumber().equals(id)) {
                return a;
            }
        }
        return null;
    }

    // Remove client
    public boolean removeClient(String id) {
        for (int i = 0; i < ClList.size(); i++) {

            Client c = ClList.get(i);

            if (c.getId().equals(id)) {
                AcList.removeAll(c.getAcList());
                ClList.remove(i);
                return true;
            }
        }
        return false;
    }

    // Calculate total amount
    public float totalAmount() {
        float total = 0;

        for (Account a : AcList) {
            total += a.getAmount();
        }
        return total;
    }

    // Search customer by CNIC
    public Client searchCustomerDetail(String CNIC) {
        for (Client c : ClList) {
            if (c.getPersonDetails().getCNIC().equals(CNIC)) {
                return c;
            }
        }
        return null;
    }

    public String toString() {
        String result = "Bank Name: " + name;
        result += "\nTotal Clients: " + ClList.size();
        result += "\nTotal Accounts: " + AcList.size();

        for (Client c : ClList) {
            result += "\n\n" + c.toString();
        }
        return result;
    }
}