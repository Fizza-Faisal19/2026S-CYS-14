class Student1{
    private String name;
    private int roll;
    private String F1name;
    private String F2name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getF1name() {
        return F1name;
    }
    public void setF1name(String f1name) {
        F1name = f1name;
    }
    public String getF2name() {
        return F2name;
    }
    public void setF2name(String f2name) {
        F2name = f2name;
    }
}
public class Task01 {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.setName("Fizza");
        s1.setRoll(14);
        s1.setF1name("Anaya");
        s1.setF2name("Ushna");
        System.out.println("Name: "+s1.getName());
        System.out.println("Roll_no: "+s1.getRoll());
        System.out.println("Friend 1: "+s1.getF1name());
        System.out.println("Friend 2: "+s1.getF2name());
    }
}