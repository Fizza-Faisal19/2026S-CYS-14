public class Task03 {
    public static void main(String[] args) {

        House h = new House();
        h.display();
    }
}
class Room{
    public Room(String name) {
        this.name = name;
    }
    void function(){
        System.out.println("Fizza"); //you'll need to make an object or initialize it in another class
    }

    String name;
}
class House{
    Room m = new Room("Room 1");

    void display(){
        System.out.println(m.name);
    }
}

