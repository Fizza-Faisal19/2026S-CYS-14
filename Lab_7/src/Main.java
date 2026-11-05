class Book{
    String name;

    public Book(String name) {
        this.name = name;
    }
    void abc(){
        System.out.println("Fizza");
    }
}
class library{
    Book b;

    public library(Book b) {
        this.b = b;
    }
    void display(){
        System.out.println(b.name);
    }
    void abc(){
        System.out.println("Hello");
    }
}
public class Main{
    public static void main(String[] args) {

        Book b1 = new Book("Java");
        library l = new library(b1);
        l.display();
        b1.abc();
        l.abc();
    }
}