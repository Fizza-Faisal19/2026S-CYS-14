class Hi{
    void sayhi(){
        System.out.println("Hi");
    }
    void Name(){
        System.out.println("Name: Fizza");
    }
    void RegNo(){
        System.out.println("RegNo:2026-(S)-CYS-14");
    }
    void City(){
        System.out.println("City: Lahore");
    }
}
class Friends{
    void Areeba(){
        System.out.println("Areeba");
    }
    void Aimen(){
        System.out.println("Aimen");
    }
}
public class Task03 {
    public static void main(String[] args) {
        Hi h= new Hi();
        h.sayhi();
        h.Name();
        h.RegNo();
        h.City();
        Friends F = new Friends();
        F.Aimen();
        F.Areeba();
    }
}