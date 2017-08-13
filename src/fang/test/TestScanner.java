package fang.test;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner("123 asdf      sd 45 789 s|df asdfl,sdf.sdfl,asdf    ......asdfkl    las");
//              s.useDelimiter("\n");//输出一行 相当于nextLine()
              s.useDelimiter(",|\\||\\.");
//        while (s.hasNext()) {
//          //  System.out.println(s.next());
//        }
        System.out.println("\\\"");
    }
}
