package 真题;


import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * 5
 * 1 2
 * 4 6
 * 7 5
 * 9 0
 * 5 3
 * <p>
 * 输出
 * 4 6
 * 5 3
 * 7 5
 * 9 0
 */
public class 一组数据右上方最大值 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Point> data = new LinkedList() ;
        for (int i = 0; i < n; i++) {
            Point p=new Point();
            p.x = in.nextInt();
            p.y = in.nextInt();
            data.add(p);
        }

        TreeMap<Integer, Integer> results = new TreeMap<>();

        results.put(data.get(0).x, data.get(0).y);
        for (Point p : data) {
            List<Integer> remove_keys = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> it = results.entrySet().iterator();
            boolean isadd=true;//是否添加这个 p
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();

                if (entry.getKey() < p.x && entry.getValue() < p.y) {//删除这个it  但不能直接删除 要记录下来
                    remove_keys.add(entry.getKey());
                    break;
                }
                if(entry.getKey() > p.x && entry.getValue() > p.y){
                    isadd=false;
                }
            }


            if(isadd){
                results.put(p.x,p.y);
            }
            for(int rm_k:remove_keys){
                results.remove(rm_k);
            }
        }


        //输出
        for(Map.Entry entry:results.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }

     static class Point {
        int x;
        int y;
    }



}
