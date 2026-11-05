public class Task02{
    public static void main(String[] args) {

        Student s = new Student("Fatima");
        Teacher l = new Teacher(s);
        l.display();
        s.abc();
        l.abc();
    }
}
class Student{
    String name;

    public Student(String name) {
        this.name = name;
    }
    void abc(){
        System.out.println("Fizza");
    }
}
class Teacher{
    Student s1;

    public Teacher(Student s1) {
        this.s1 = s1;
    }
    void display(){
        System.out.println(s1.name);
    }
    void abc(){
        System.out.println("Anaya");
    }
}
