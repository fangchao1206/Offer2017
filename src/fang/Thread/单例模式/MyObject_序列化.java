package fang.Thread.单例模式;

import java.io.*;

/**
 * 利用序列化和反序列化实现单例模式
 * Created by fangchao05 on 2017/7/28.
 */
public class MyObject_序列化 implements Serializable {
    private static final long serialVersionUID = 888L;

    //内部类方式
    private static class MyObjHandler {
        private static MyObject_序列化 myObject = new MyObject_序列化();
    }

    private MyObject_序列化() {
        System.out.println("单例 构造函数");
    }

    public static MyObject_序列化 getInstance() {
        return MyObjHandler.myObject;
    }

    /**
     * 这段代码不能少 否则反序列话回来 就不是之前那个instance了
     * @return
     * @throws ObjectStreamException
     */
    Object readResolve() throws ObjectStreamException {
        return MyObject_序列化.getInstance();
    }
}

class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyObject_序列化 myObject_x = MyObject_序列化.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d://out.txt"));
        objectOutputStream.writeObject(myObject_x);
        objectOutputStream.close();
        System.out.println(myObject_x.hashCode());

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d://out.txt"));
        MyObject_序列化 myObject = (MyObject_序列化) inputStream.readObject();
        inputStream.close();
        System.out.println(myObject.hashCode());
    }
}