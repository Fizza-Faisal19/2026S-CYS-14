class Student1{
    String name = "Fizza";
}
class Teacher1{
    void Student1(Student1 s2){
        System.out.println(s2.name);
    }
}
public class Task02{
    public static void main(String[] args) {
        Student1 s = new Student1();
        Teacher1 t = new Teacher1();
        t.Student1(s);
    }
}
