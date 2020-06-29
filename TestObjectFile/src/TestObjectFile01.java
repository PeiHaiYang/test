
import java.io.*;

/**
 * @author PHY
 * @date 2020-06-17$-10:40
 */
public class TestObjectFile01 {
    /*
    进行对象流的测试
     */
    public static void main(String[] args) {
        testObjectOutputStream();
        TestObjectInputStream();
    }
    public  static void testObjectOutputStream(){
       //造流
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //选择流的方式
            objectOutputStream.writeObject("hello world");
            objectOutputStream.flush();
            objectOutputStream.writeObject(new Person(11,"你好世界",new Accunt()));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          if (objectOutputStream!=null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //关闭流
    }
    public static void  TestObjectInputStream(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object object = objectInputStream.readObject();
            String string = (String) object;
            Object p = objectInputStream.readObject();
            Person person= (Person) p;
            System.out.println(string);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
