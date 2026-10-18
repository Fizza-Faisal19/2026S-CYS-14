class Student{
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
public class Task02 {
    public static void main(String[] args) {
        Student s1 = new Student("Fizza", 19);
        System.out.println("Name: "+s1.getName());
        System.out.println("Age: "+s1.getAge());
    }
}