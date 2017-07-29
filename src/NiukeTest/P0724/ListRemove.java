package NiukeTest.P0724;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class ListRemove {
    static List list = new ArrayList();

    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator it = list.iterator();
        it.next();
        it.remove();
        for (; it.hasNext(); ) {

            System.out.println(it.next());

        }
    }
}
