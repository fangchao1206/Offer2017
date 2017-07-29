package NiukeTest;

public class EnumTest {
	public static void main(String[] args) {
        for (Enum1 e : Enum1.values()) {
            System.out.println(e.toString());
        }
         
        System.out.println("----------------我是分隔线------------------");
         
        Enum1 test = Enum1.TUE;
        switch (test) {
        case MON:
            System.out.println("今天是星期一");
            break;
        case TUE:
            System.out.println("今天是星期二");
            break;
    
        // ... ...
        default:
            System.out.println(test);
            break;
        }
    }
}
