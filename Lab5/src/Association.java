class Student {
    String name = "Fizza";

    public Student(String name) {
        this.name = name;
    }
}
class Teacher{
    void Student (Student s1){
        System.out.println(s1.name);
    }
}
public class Association{
    public static void main(String[] args) {
        Student s = new Student("Fizza");
             Teacher t = new Teacher();
       t.Student(s);
    }
}
