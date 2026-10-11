public class Task2 {
    public static void main(String[] arg){
        //Before swapping
     int a = 50;
     int b = 34;
     System.out.println("Print number before  swapping: "+ a + "," + b);
      //After swapping
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Print number after swapping: "+ a + "," + b);
    }
}
