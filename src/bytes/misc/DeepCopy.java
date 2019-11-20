package bytes.misc;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class DeepCopy {

    public void start() {
        A a = new A();
        A aa = null;
        try {
            aa = (A) deepCopy(a);
            System.out.println(a == aa);
            aa.list.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object deepCopy(Object oldObject) {

        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            //Write the old object to the stream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(oldObject);
            objectOutputStream.flush();

            //Now read from the stream to create a new object - use the above byteArrayOutputStream
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

class A implements Serializable {
    String a;
    List<String> list;
    A() {
        a = "abc";
        list = Collections.singletonList("aaa");
    }
}
